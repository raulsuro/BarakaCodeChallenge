import 'package:flutter_app/pigeon.dart';

class StocksInvestRepository {
  final StockInvestApi stockService;

  StocksInvestRepository({required this.stockService});

  Future<List<StockInvest?>> retrieveInvestedStocks() async {
    final fetchedInvestedStocks = await stockService.getStocksInvest();
    return fetchedInvestedStocks.whereType<StockInvest>().toList();
  }
}
