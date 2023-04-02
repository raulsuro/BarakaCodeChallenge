import 'package:flutter/material.dart';
import 'package:flutter_app/data/repository/stocks_invested_repository.dart';
import 'package:flutter_app/presentation/viewmodels/stocks_invest_viewmodel.dart';
import 'package:provider/provider.dart';

import '../../pigeon.dart';

class SecondRoute extends StatelessWidget {
  const SecondRoute({super.key});

  @override
  Widget build(BuildContext context) {
    final api = StockInvestApi();
    final investRepository = StocksInvestRepository(stockService: api);
    return MultiProvider(
      providers: [
        ChangeNotifierProvider<StocksInvestViewModel>(
          create: (_) => StocksInvestViewModel(repository: investRepository),
        ),
      ],
      child: Scaffold(
        appBar: AppBar(
          title: const Text('My Stocks'),
        ),
        body: StockList(),
      ),
    );
  }
}

class StockList extends StatefulWidget {
  @override
  _StockListState createState() => _StockListState();
}

class _StockListState extends State<StockList> {
  List<StockInvest> stocks = [];

  double totalInvestedAmount = 0.0;
  double totalLastPrice = 0.0;
  double totalPnL = 0.0;
  late StocksInvestViewModel stocksInvestViewModel;

  @override
  void initState() {
    super.initState();
  }

  void calculateTotals() {
    for (StockInvest stock in stocks) {
      totalInvestedAmount += stock.investedTotal!;
      totalLastPrice += stock.currentValue!;
    }
    totalPnL = totalLastPrice - totalInvestedAmount;
  }

  void refreshStocks(newStocks) {
    stocks = newStocks;
    calculateTotals();
  }

  @override
  Widget build(BuildContext context) {
    stocksInvestViewModel = context.watch<StocksInvestViewModel>();
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Color(0xFF1C1C1C),
        body: Column(
          children: [
            if (stocksInvestViewModel.listInvestedStocks.isNotEmpty)
              Padding(
                padding: const EdgeInsets.all(16.0),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    const Text(
                      'Total P&L:',
                      style: TextStyle(
                        fontSize: 20.0,
                        fontWeight: FontWeight.bold,
                        color: Colors.white,
                      ),
                    ),
                    const SizedBox(height: 8.0),
                    Row(
                      children: [
                        Text(
                          stocksInvestViewModel.totalPnL.toStringAsFixed(2),
                          style: TextStyle(
                            fontSize: 22.0,
                            fontWeight: FontWeight.bold,
                            color: stocksInvestViewModel.totalPnL >= 0
                                ? Colors.green
                                : Colors.red,
                          ),
                        ),
                        const SizedBox(width: 8.0),
                        Text(
                          '(${(stocksInvestViewModel.totalPnL / stocksInvestViewModel.totalInvestedAmount * 100).toStringAsFixed(2)}%)',
                          style: TextStyle(
                            fontSize: 18.0,
                            fontWeight: FontWeight.bold,
                            color: Colors.grey[400],
                          ),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
            if (stocksInvestViewModel.isLoading)
              const Expanded(
                child: Center(
                  child: CircularProgressIndicator(),
                ),
              ),
            if (stocksInvestViewModel.listInvestedStocks.isEmpty &&
                !stocksInvestViewModel.isLoading)
              Expanded(
                child: Center(
                  child: Text(
                    'No stocks invested yet',
                    style: TextStyle(
                      fontSize: 18.0,
                      fontWeight: FontWeight.bold,
                      color: Colors.grey[400],
                    ),
                  ),
                ),
              ),
            if (stocksInvestViewModel.listInvestedStocks.isNotEmpty)
              Expanded(
                child: ListView.builder(
                  itemCount: stocksInvestViewModel.listInvestedStocks.length,
                  itemBuilder: (BuildContext context, int index) {
                    StockInvest stock =
                        stocksInvestViewModel.listInvestedStocks[index];
                    return Padding(
                      padding: const EdgeInsets.symmetric(
                          horizontal: 8.0, vertical: 4.0),
                      child: Card(
                        child: ListTile(
                          title: Text(
                            stock.name!,
                            style: const TextStyle(
                              fontSize: 18.0,
                              fontWeight: FontWeight.bold,
                              color: Color.fromARGB(255, 78, 78, 78),
                            ),
                          ),
                          subtitle: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              const SizedBox(height: 8.0),
                              Text(
                                  'Invested Amount: ${stock.investedTotal?.toStringAsFixed(2)}'),
                              const SizedBox(height: 8.0),
                              Text(
                                  'Average Price: ${stock.averagePrice?.toStringAsFixed(2)}'),
                              const SizedBox(height: 8.0),
                              Text(
                                  'Last Traded Price: ${stock.ltp?.toStringAsFixed(2)}'),
                              const SizedBox(height: 8.0),
                              Text('Total Quantity: ${stock.quantity}'),
                              const SizedBox(height: 8.0),
                              Text(
                                  'P&L: ${stock.pl?.toStringAsFixed(2)} ${stock.percentagePL?.toStringAsFixed(2)}%'),
                              const SizedBox(height: 8.0),
                            ],
                          ),
                        ),
                      ),
                    );
                  },
                ),
              ),
          ],
        ),
      ),
    );
  }
}
