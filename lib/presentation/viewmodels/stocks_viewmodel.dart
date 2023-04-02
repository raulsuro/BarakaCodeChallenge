import 'dart:async';
import 'package:flutter/material.dart';
import 'package:flutter_app/data/repository/stocks_repository.dart';
import '../../pigeon.dart';

class StocksViewModel extends ChangeNotifier {
  final StocksRepository _repository;

  StocksViewModel({required StocksRepository repository})
      : _repository = repository;

  List<Stock> _stocks = [];

  List<Stock> get chartData => _stocks;

  bool _isLoading = false;

  bool get isLoading => _isLoading;

  Future<void> fetchStocks(String ticker, String function) async {
    try {
      _isLoading = true;
      notifyListeners();
      final fetchedStocks = await _repository.retrieveStocks(ticker, function);
      _stocks = fetchedStocks.whereType<Stock>().toList();
      _isLoading = false;
      notifyListeners();
    } catch (error) {
      _isLoading = false;
      notifyListeners();
      rethrow;
    }
  }

  // TODO: Add a method to fetch stocks info with id to allow multiple replies
  // int _nextId = 0;

  // Future<void> fetchStocksInfo(MyRequest request) async {
  //   try {
  //     final id = (_nextId++).toString();
  //     request.id = id;
  //     _isLoading = true;
  //     notifyListeners();
  //     final response = await MyApi().getStocksInfo(request);
  //     if (response.result != null) {
  //       _stocks = response.result!.whereType<Stock>().toList();
  //     } else {
  //       _stocks = [];
  //     }
  //     _isLoading = false;
  //     notifyListeners();
  //   } catch (error) {
  //     _isLoading = false;
  //     notifyListeners();
  //     rethrow;
  //   }
  // }
}
