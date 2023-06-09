// Autogenerated from Pigeon (v9.1.1), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package io.flutter.plugins;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression", "serial"})
public class Pigeon {

  /** Error class for passing custom error details to Flutter via a thrown PlatformException. */
  public static class FlutterError extends RuntimeException {

    /** The error code. */
    public final String code;

    /** The error details. Must be a datatype supported by the api codec. */
    public final Object details;

    public FlutterError(@NonNull String code, @Nullable String message, @Nullable Object details) 
    {
      super(message);
      this.code = code;
      this.details = details;
    }
  }

  @NonNull
  private static ArrayList<Object> wrapError(@NonNull Throwable exception) {
    ArrayList<Object> errorList = new ArrayList<Object>(3);
    if (exception instanceof FlutterError) {
      FlutterError error = (FlutterError) exception;
      errorList.add(error.code);
      errorList.add(error.getMessage());
      errorList.add(error.details);
    } else {
      errorList.add(exception.toString());
      errorList.add(exception.getClass().getSimpleName());
      errorList.add(
        "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    }
    return errorList;
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static final class Stock {
    private @Nullable String symbol;

    public @Nullable String getSymbol() {
      return symbol;
    }

    public void setSymbol(@Nullable String setterArg) {
      this.symbol = setterArg;
    }

    private @Nullable String name;

    public @Nullable String getName() {
      return name;
    }

    public void setName(@Nullable String setterArg) {
      this.name = setterArg;
    }

    private @Nullable Double price;

    public @Nullable Double getPrice() {
      return price;
    }

    public void setPrice(@Nullable Double setterArg) {
      this.price = setterArg;
    }

    private @Nullable String date;

    public @Nullable String getDate() {
      return date;
    }

    public void setDate(@Nullable String setterArg) {
      this.date = setterArg;
    }

    private @Nullable Double change;

    public @Nullable Double getChange() {
      return change;
    }

    public void setChange(@Nullable Double setterArg) {
      this.change = setterArg;
    }

    private @Nullable Double percentChange;

    public @Nullable Double getPercentChange() {
      return percentChange;
    }

    public void setPercentChange(@Nullable Double setterArg) {
      this.percentChange = setterArg;
    }

    public static final class Builder {

      private @Nullable String symbol;

      public @NonNull Builder setSymbol(@Nullable String setterArg) {
        this.symbol = setterArg;
        return this;
      }

      private @Nullable String name;

      public @NonNull Builder setName(@Nullable String setterArg) {
        this.name = setterArg;
        return this;
      }

      private @Nullable Double price;

      public @NonNull Builder setPrice(@Nullable Double setterArg) {
        this.price = setterArg;
        return this;
      }

      private @Nullable String date;

      public @NonNull Builder setDate(@Nullable String setterArg) {
        this.date = setterArg;
        return this;
      }

      private @Nullable Double change;

      public @NonNull Builder setChange(@Nullable Double setterArg) {
        this.change = setterArg;
        return this;
      }

      private @Nullable Double percentChange;

      public @NonNull Builder setPercentChange(@Nullable Double setterArg) {
        this.percentChange = setterArg;
        return this;
      }

      public @NonNull Stock build() {
        Stock pigeonReturn = new Stock();
        pigeonReturn.setSymbol(symbol);
        pigeonReturn.setName(name);
        pigeonReturn.setPrice(price);
        pigeonReturn.setDate(date);
        pigeonReturn.setChange(change);
        pigeonReturn.setPercentChange(percentChange);
        return pigeonReturn;
      }
    }

    @NonNull
    ArrayList<Object> toList() {
      ArrayList<Object> toListResult = new ArrayList<Object>(6);
      toListResult.add(symbol);
      toListResult.add(name);
      toListResult.add(price);
      toListResult.add(date);
      toListResult.add(change);
      toListResult.add(percentChange);
      return toListResult;
    }

    static @NonNull Stock fromList(@NonNull ArrayList<Object> list) {
      Stock pigeonResult = new Stock();
      Object symbol = list.get(0);
      pigeonResult.setSymbol((String) symbol);
      Object name = list.get(1);
      pigeonResult.setName((String) name);
      Object price = list.get(2);
      pigeonResult.setPrice((Double) price);
      Object date = list.get(3);
      pigeonResult.setDate((String) date);
      Object change = list.get(4);
      pigeonResult.setChange((Double) change);
      Object percentChange = list.get(5);
      pigeonResult.setPercentChange((Double) percentChange);
      return pigeonResult;
    }
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static final class StockInvest {
    private @Nullable String symbol;

    public @Nullable String getSymbol() {
      return symbol;
    }

    public void setSymbol(@Nullable String setterArg) {
      this.symbol = setterArg;
    }

    private @Nullable String name;

    public @Nullable String getName() {
      return name;
    }

    public void setName(@Nullable String setterArg) {
      this.name = setterArg;
    }

    private @Nullable Double investedTotal;

    public @Nullable Double getInvestedTotal() {
      return investedTotal;
    }

    public void setInvestedTotal(@Nullable Double setterArg) {
      this.investedTotal = setterArg;
    }

    private @Nullable Double quantity;

    public @Nullable Double getQuantity() {
      return quantity;
    }

    public void setQuantity(@Nullable Double setterArg) {
      this.quantity = setterArg;
    }

    private @Nullable Double currentValue;

    public @Nullable Double getCurrentValue() {
      return currentValue;
    }

    public void setCurrentValue(@Nullable Double setterArg) {
      this.currentValue = setterArg;
    }

    private @Nullable Double pl;

    public @Nullable Double getPl() {
      return pl;
    }

    public void setPl(@Nullable Double setterArg) {
      this.pl = setterArg;
    }

    private @Nullable Double percentagePL;

    public @Nullable Double getPercentagePL() {
      return percentagePL;
    }

    public void setPercentagePL(@Nullable Double setterArg) {
      this.percentagePL = setterArg;
    }

    private @Nullable Double averagePrice;

    public @Nullable Double getAveragePrice() {
      return averagePrice;
    }

    public void setAveragePrice(@Nullable Double setterArg) {
      this.averagePrice = setterArg;
    }

    private @Nullable Double ltp;

    public @Nullable Double getLtp() {
      return ltp;
    }

    public void setLtp(@Nullable Double setterArg) {
      this.ltp = setterArg;
    }

    public static final class Builder {

      private @Nullable String symbol;

      public @NonNull Builder setSymbol(@Nullable String setterArg) {
        this.symbol = setterArg;
        return this;
      }

      private @Nullable String name;

      public @NonNull Builder setName(@Nullable String setterArg) {
        this.name = setterArg;
        return this;
      }

      private @Nullable Double investedTotal;

      public @NonNull Builder setInvestedTotal(@Nullable Double setterArg) {
        this.investedTotal = setterArg;
        return this;
      }

      private @Nullable Double quantity;

      public @NonNull Builder setQuantity(@Nullable Double setterArg) {
        this.quantity = setterArg;
        return this;
      }

      private @Nullable Double currentValue;

      public @NonNull Builder setCurrentValue(@Nullable Double setterArg) {
        this.currentValue = setterArg;
        return this;
      }

      private @Nullable Double pl;

      public @NonNull Builder setPl(@Nullable Double setterArg) {
        this.pl = setterArg;
        return this;
      }

      private @Nullable Double percentagePL;

      public @NonNull Builder setPercentagePL(@Nullable Double setterArg) {
        this.percentagePL = setterArg;
        return this;
      }

      private @Nullable Double averagePrice;

      public @NonNull Builder setAveragePrice(@Nullable Double setterArg) {
        this.averagePrice = setterArg;
        return this;
      }

      private @Nullable Double ltp;

      public @NonNull Builder setLtp(@Nullable Double setterArg) {
        this.ltp = setterArg;
        return this;
      }

      public @NonNull StockInvest build() {
        StockInvest pigeonReturn = new StockInvest();
        pigeonReturn.setSymbol(symbol);
        pigeonReturn.setName(name);
        pigeonReturn.setInvestedTotal(investedTotal);
        pigeonReturn.setQuantity(quantity);
        pigeonReturn.setCurrentValue(currentValue);
        pigeonReturn.setPl(pl);
        pigeonReturn.setPercentagePL(percentagePL);
        pigeonReturn.setAveragePrice(averagePrice);
        pigeonReturn.setLtp(ltp);
        return pigeonReturn;
      }
    }

    @NonNull
    ArrayList<Object> toList() {
      ArrayList<Object> toListResult = new ArrayList<Object>(9);
      toListResult.add(symbol);
      toListResult.add(name);
      toListResult.add(investedTotal);
      toListResult.add(quantity);
      toListResult.add(currentValue);
      toListResult.add(pl);
      toListResult.add(percentagePL);
      toListResult.add(averagePrice);
      toListResult.add(ltp);
      return toListResult;
    }

    static @NonNull StockInvest fromList(@NonNull ArrayList<Object> list) {
      StockInvest pigeonResult = new StockInvest();
      Object symbol = list.get(0);
      pigeonResult.setSymbol((String) symbol);
      Object name = list.get(1);
      pigeonResult.setName((String) name);
      Object investedTotal = list.get(2);
      pigeonResult.setInvestedTotal((Double) investedTotal);
      Object quantity = list.get(3);
      pigeonResult.setQuantity((Double) quantity);
      Object currentValue = list.get(4);
      pigeonResult.setCurrentValue((Double) currentValue);
      Object pl = list.get(5);
      pigeonResult.setPl((Double) pl);
      Object percentagePL = list.get(6);
      pigeonResult.setPercentagePL((Double) percentagePL);
      Object averagePrice = list.get(7);
      pigeonResult.setAveragePrice((Double) averagePrice);
      Object ltp = list.get(8);
      pigeonResult.setLtp((Double) ltp);
      return pigeonResult;
    }
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static final class MyRequest {
    private @Nullable String id;

    public @Nullable String getId() {
      return id;
    }

    public void setId(@Nullable String setterArg) {
      this.id = setterArg;
    }

    private @Nullable String ticker;

    public @Nullable String getTicker() {
      return ticker;
    }

    public void setTicker(@Nullable String setterArg) {
      this.ticker = setterArg;
    }

    private @Nullable String function;

    public @Nullable String getFunction() {
      return function;
    }

    public void setFunction(@Nullable String setterArg) {
      this.function = setterArg;
    }

    public static final class Builder {

      private @Nullable String id;

      public @NonNull Builder setId(@Nullable String setterArg) {
        this.id = setterArg;
        return this;
      }

      private @Nullable String ticker;

      public @NonNull Builder setTicker(@Nullable String setterArg) {
        this.ticker = setterArg;
        return this;
      }

      private @Nullable String function;

      public @NonNull Builder setFunction(@Nullable String setterArg) {
        this.function = setterArg;
        return this;
      }

      public @NonNull MyRequest build() {
        MyRequest pigeonReturn = new MyRequest();
        pigeonReturn.setId(id);
        pigeonReturn.setTicker(ticker);
        pigeonReturn.setFunction(function);
        return pigeonReturn;
      }
    }

    @NonNull
    ArrayList<Object> toList() {
      ArrayList<Object> toListResult = new ArrayList<Object>(3);
      toListResult.add(id);
      toListResult.add(ticker);
      toListResult.add(function);
      return toListResult;
    }

    static @NonNull MyRequest fromList(@NonNull ArrayList<Object> list) {
      MyRequest pigeonResult = new MyRequest();
      Object id = list.get(0);
      pigeonResult.setId((String) id);
      Object ticker = list.get(1);
      pigeonResult.setTicker((String) ticker);
      Object function = list.get(2);
      pigeonResult.setFunction((String) function);
      return pigeonResult;
    }
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static final class MyResponse {
    private @Nullable String id;

    public @Nullable String getId() {
      return id;
    }

    public void setId(@Nullable String setterArg) {
      this.id = setterArg;
    }

    private @Nullable List<Stock> result;

    public @Nullable List<Stock> getResult() {
      return result;
    }

    public void setResult(@Nullable List<Stock> setterArg) {
      this.result = setterArg;
    }

    public static final class Builder {

      private @Nullable String id;

      public @NonNull Builder setId(@Nullable String setterArg) {
        this.id = setterArg;
        return this;
      }

      private @Nullable List<Stock> result;

      public @NonNull Builder setResult(@Nullable List<Stock> setterArg) {
        this.result = setterArg;
        return this;
      }

      public @NonNull MyResponse build() {
        MyResponse pigeonReturn = new MyResponse();
        pigeonReturn.setId(id);
        pigeonReturn.setResult(result);
        return pigeonReturn;
      }
    }

    @NonNull
    ArrayList<Object> toList() {
      ArrayList<Object> toListResult = new ArrayList<Object>(2);
      toListResult.add(id);
      toListResult.add(result);
      return toListResult;
    }

    static @NonNull MyResponse fromList(@NonNull ArrayList<Object> list) {
      MyResponse pigeonResult = new MyResponse();
      Object id = list.get(0);
      pigeonResult.setId((String) id);
      Object result = list.get(1);
      pigeonResult.setResult((List<Stock>) result);
      return pigeonResult;
    }
  }

  public interface Result<T> {
    void success(T result);

    void error(Throwable error);
  }

  private static class MyApiCodec extends StandardMessageCodec {
    public static final MyApiCodec INSTANCE = new MyApiCodec();

    private MyApiCodec() {}

    @Override
    protected Object readValueOfType(byte type, @NonNull ByteBuffer buffer) {
      switch (type) {
        case (byte) 128:
          return MyRequest.fromList((ArrayList<Object>) readValue(buffer));
        case (byte) 129:
          return MyResponse.fromList((ArrayList<Object>) readValue(buffer));
        case (byte) 130:
          return Stock.fromList((ArrayList<Object>) readValue(buffer));
        default:
          return super.readValueOfType(type, buffer);
      }
    }

    @Override
    protected void writeValue(@NonNull ByteArrayOutputStream stream, Object value) {
      if (value instanceof MyRequest) {
        stream.write(128);
        writeValue(stream, ((MyRequest) value).toList());
      } else if (value instanceof MyResponse) {
        stream.write(129);
        writeValue(stream, ((MyResponse) value).toList());
      } else if (value instanceof Stock) {
        stream.write(130);
        writeValue(stream, ((Stock) value).toList());
      } else {
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter. */
  public interface MyApi {

    void getStocksInfo(@NonNull MyRequest request, Result<MyResponse> result);

    /** The codec used by MyApi. */
    static MessageCodec<Object> getCodec() {
      return MyApiCodec.INSTANCE;
    }
    /**Sets up an instance of `MyApi` to handle messages through the `binaryMessenger`. */
    static void setup(BinaryMessenger binaryMessenger, MyApi api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger, "dev.flutter.pigeon.MyApi.getStocksInfo", getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<Object>();
                ArrayList<Object> args = (ArrayList<Object>) message;
                MyRequest requestArg = (MyRequest) args.get(0);
                Result<MyResponse> resultCallback =
                    new Result<MyResponse>() {
                      public void success(MyResponse result) {
                        wrapped.add(0, result);
                        reply.reply(wrapped);
                      }

                      public void error(Throwable error) {
                        ArrayList<Object> wrappedError = wrapError(error);
                        reply.reply(wrappedError);
                      }
                    };

                api.getStocksInfo(requestArg, resultCallback);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }

  private static class StockApiCodec extends StandardMessageCodec {
    public static final StockApiCodec INSTANCE = new StockApiCodec();

    private StockApiCodec() {}

    @Override
    protected Object readValueOfType(byte type, @NonNull ByteBuffer buffer) {
      switch (type) {
        case (byte) 128:
          return Stock.fromList((ArrayList<Object>) readValue(buffer));
        default:
          return super.readValueOfType(type, buffer);
      }
    }

    @Override
    protected void writeValue(@NonNull ByteArrayOutputStream stream, Object value) {
      if (value instanceof Stock) {
        stream.write(128);
        writeValue(stream, ((Stock) value).toList());
      } else {
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter. */
  public interface StockApi {

    void getStocks(@NonNull String ticker, @NonNull String function, Result<List<Stock>> result);

    /** The codec used by StockApi. */
    static MessageCodec<Object> getCodec() {
      return StockApiCodec.INSTANCE;
    }
    /**Sets up an instance of `StockApi` to handle messages through the `binaryMessenger`. */
    static void setup(BinaryMessenger binaryMessenger, StockApi api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger, "dev.flutter.pigeon.StockApi.getStocks", getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<Object>();
                ArrayList<Object> args = (ArrayList<Object>) message;
                String tickerArg = (String) args.get(0);
                String functionArg = (String) args.get(1);
                Result<List<Stock>> resultCallback =
                    new Result<List<Stock>>() {
                      public void success(List<Stock> result) {
                        wrapped.add(0, result);
                        reply.reply(wrapped);
                      }

                      public void error(Throwable error) {
                        ArrayList<Object> wrappedError = wrapError(error);
                        reply.reply(wrappedError);
                      }
                    };

                api.getStocks(tickerArg, functionArg, resultCallback);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }

  private static class StockInvestApiCodec extends StandardMessageCodec {
    public static final StockInvestApiCodec INSTANCE = new StockInvestApiCodec();

    private StockInvestApiCodec() {}

    @Override
    protected Object readValueOfType(byte type, @NonNull ByteBuffer buffer) {
      switch (type) {
        case (byte) 128:
          return StockInvest.fromList((ArrayList<Object>) readValue(buffer));
        default:
          return super.readValueOfType(type, buffer);
      }
    }

    @Override
    protected void writeValue(@NonNull ByteArrayOutputStream stream, Object value) {
      if (value instanceof StockInvest) {
        stream.write(128);
        writeValue(stream, ((StockInvest) value).toList());
      } else {
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter. */
  public interface StockInvestApi {

    void getStocksInvest(Result<List<StockInvest>> result);

    /** The codec used by StockInvestApi. */
    static MessageCodec<Object> getCodec() {
      return StockInvestApiCodec.INSTANCE;
    }
    /**Sets up an instance of `StockInvestApi` to handle messages through the `binaryMessenger`. */
    static void setup(BinaryMessenger binaryMessenger, StockInvestApi api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger, "dev.flutter.pigeon.StockInvestApi.getStocksInvest", getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<Object>();
                Result<List<StockInvest>> resultCallback =
                    new Result<List<StockInvest>>() {
                      public void success(List<StockInvest> result) {
                        wrapped.add(0, result);
                        reply.reply(wrapped);
                      }

                      public void error(Throwable error) {
                        ArrayList<Object> wrappedError = wrapError(error);
                        reply.reply(wrappedError);
                      }
                    };

                api.getStocksInvest(resultCallback);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
}
