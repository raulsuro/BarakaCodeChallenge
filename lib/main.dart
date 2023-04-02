import 'package:flutter/material.dart';
import 'package:flutter_app/data/repository/stocks_repository.dart';
import 'package:flutter_app/pigeon.dart';
import 'package:flutter_app/presentation/viewmodels/stocks_viewmodel.dart';
import 'package:provider/provider.dart';
import 'presentation/view/stock_chart.dart';

@pragma("vm:entry-point")
void nativeLoad() async {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const MyHomePage());
}

void main(List<String> args) {
  runApp(const MyHomePage());
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    final api = StockApi();
    final repository = StocksRepository(stockService: api);

    return MultiProvider(
      providers: [
        ChangeNotifierProvider<StocksViewModel>(
          create: (_) => StocksViewModel(repository: repository),
        ),
      ],
      child: const MaterialApp(home: StockChart()),
    );
  }
}
