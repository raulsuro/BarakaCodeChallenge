import 'package:flutter/material.dart';
import 'package:flutter_app/data/repository/stocks_invested_repository.dart';
import 'package:flutter_app/pigeon.dart';

class StocksInvestViewModel extends ChangeNotifier {
  late final StocksInvestRepository _repository;

  List<StockInvest> _stocksInvested = [];

  List<StockInvest> get listInvestedStocks => _stocksInvested;

  StocksInvestViewModel({required StocksInvestRepository repository}) {
    _repository = repository;
    if (listInvestedStocks.isEmpty) fetchInvestedStocks();
  }

  bool _isLoading = false;

  bool get isLoading => _isLoading;

  double _totalInvestedAmount = 0;

  double get totalInvestedAmount => _totalInvestedAmount;

  set totalInvestedAmount(double value) {
    _totalInvestedAmount = value;
    notifyListeners();
  }

  double _totalLastPrice = 0;

  double get totalLastPrice => _totalLastPrice;

  set totalLastPrice(double value) {
    _totalLastPrice = value;
    notifyListeners();
  }

  double _totalPnL = 0;

  double get totalPnL => _totalPnL;

  set totalPnL(double value) {
    _totalPnL = value;
    notifyListeners();
  }

  Future<void> fetchInvestedStocks() async {
    try {
      _isLoading = true;
      notifyListeners();
      final fetchedStocks = await _repository.retrieveInvestedStocks();
      _stocksInvested = fetchedStocks.whereType<StockInvest>().toList();
      calculateTotals();
      _isLoading = false;
      notifyListeners();
    } catch (error) {
      _isLoading = false;
      notifyListeners();
      rethrow;
    }
  }

  void calculateTotals() {
    for (StockInvest stock in _stocksInvested) {
      totalInvestedAmount += stock.investedTotal!;
      totalLastPrice += stock.currentValue!;
    }
    totalPnL = totalLastPrice - totalInvestedAmount;
  }
}
