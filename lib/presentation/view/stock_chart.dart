import 'package:easy_search_bar/easy_search_bar.dart';
import 'package:flutter/material.dart';
import 'package:flutter_app/pigeon.dart';
import 'package:flutter_app/presentation/view/stock_list.dart';
import 'package:flutter_app/presentation/viewmodels/stocks_viewmodel.dart';
import 'package:provider/provider.dart';
import 'package:syncfusion_flutter_charts/charts.dart';

class StockChart extends StatefulWidget {
  const StockChart({Key? key}) : super(key: key);

  @override
  State<StockChart> createState() => _StockChartState();
}

class _StockChartState extends State<StockChart> {
  List<Stock> listStock = [];

  @override
  void initState() {
    super.initState();
  }

  String searchValue = '';
  final List<String> _suggestions = [
    'AAPL',
    'AMZN',
    'GOOGL',
    'MSFT',
    'TSLA',
    'JPM',
    'BAC',
    'C',
    'WFC',
    'BA',
    'GE',
    'GM',
    'F',
    'T',
    'VZ',
    'DIS',
    'NFLX',
    'TGT',
    'WMT',
    'CVS',
    'WBA',
    'MRK',
    'PFE',
    'JNJ',
    'V',
    'MA',
    'KO',
    'PEP',
    'NKE'
  ];

  String searchText = '';
  late StocksViewModel stocksViewModel;
  @override
  Widget build(BuildContext context) {
    stocksViewModel = context.watch<StocksViewModel>();
    return Consumer<StocksViewModel>(
        builder: (context, model, child) => GestureDetector(
            onTap: () {
              FocusManager.instance.primaryFocus?.unfocus();
            },
            child: Scaffold(
                appBar: EasySearchBar(
                  title: const Text('Stocks'),
                  onSuggestionTap: (data) => {
                    FocusScope.of(context).unfocus(),
                    stocksViewModel.fetchStocks(data, "TIME_SERIES_WEEKLY")
                  },
                  onSearch: (value) => setState(() => searchValue = value),
                  suggestions: _suggestions,
                ),
                body: _buildChart())));
  }

  Widget _buildIntervalButton(String text) {
    return ElevatedButton(
      onPressed: () {
        // TODO: implement interval button
        //stocksViewModel.fetchStocks(searchText, "TIME_SERIES_DAILY");
      },
      child: Text(text),
    );
  }

  Widget _buildChart() {
    return Column(
      children: [
        if (stocksViewModel.chartData.isNotEmpty)
          Padding(
              padding:
                  const EdgeInsets.symmetric(horizontal: 8.0, vertical: 8.0),
              child: Align(
                  alignment: Alignment.centerLeft,
                  child: Text(
                      "${stocksViewModel.chartData[0].symbol} \$${stocksViewModel.chartData[0].price}",
                      textAlign: TextAlign.left,
                      style: const TextStyle(
                          color: Colors.black87,
                          fontSize: 22,
                          fontFamily: 'HelveticaNeue',
                          fontWeight: FontWeight.w400)))),
        Expanded(
          child: Stack(
            children: [
              SfCartesianChart(
                primaryXAxis: DateTimeAxis(),
                series: <LineSeries<Stock, DateTime>>[
                  LineSeries<Stock, DateTime>(
                    dataSource: stocksViewModel.chartData
                        .where((stock) => stock != null)
                        .cast<Stock>()
                        .toList(),
                    xValueMapper: (Stock stock, _) =>
                        DateTime.parse(stock.date!),
                    yValueMapper: (Stock stock, _) => stock.price,
                  ),
                ],
              ),
              if (stocksViewModel.isLoading)
                const Center(
                  child: CircularProgressIndicator(),
                ),
            ],
          ),
        ),
        Container(
          height: 50,
          color: Colors.grey[200],
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              _buildIntervalButton('1D'),
              _buildIntervalButton('1W'),
              _buildIntervalButton('1M'),
              _buildIntervalButton('3M'),
              _buildIntervalButton('1Y'),
              _buildIntervalButton('5Y'),
            ],
          ),
        ),
        ElevatedButton(
          style: ElevatedButton.styleFrom(backgroundColor: Colors.green),
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => const SecondRoute()),
            );
          },
          child: const Text('Open Investments'),
        ),
      ],
    );
  }
}
