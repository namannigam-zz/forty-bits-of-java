package edu.forty.bits.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Imperative {

    public static StockInfo dummy = new StockInfo("", 0.0);

    public void findImperative(List<String> symbols) {
        List<StockInfo> stocks = new ArrayList<>();
        for (String symbol : symbols) {
            stocks.add(StockUtil.getPrice(symbol));
        }
        List<StockInfo> stockLessThan500 = new ArrayList<>();
        for (StockInfo stock : stocks) {
            if (StockUtil.isPriceLessThan(500).test(stock)) {
                stockLessThan500.add(stock);
            }
        }

        StockInfo highPriced = dummy;
        for (StockInfo stock : stockLessThan500) {
            highPriced = StockUtil.pickHigh(highPriced, stock);
        }

        System.out.println(highPriced);
    }

    public void findFunctional(Stream<String> symbols) {
        System.out.println(symbols.map(StockUtil::getPrice).filter(StockUtil.isPriceLessThan(500))
                .reduce(dummy, StockUtil::pickHigh));
    }

    public static void main(String[] args) {
        // get me the highest stock price less than 500 dollars from pickers.symbols
//        Timeit.code(() -> findImperative(Tickers.symbols));
//        Timeit.code(() -> findFunctional(Tickers.symbols));
//        Timeit.code(() -> findFunctional(Tickers.symbols.stream()));
//        Timeit.code(() -> findFunctional(Tickers.symbols.parallelStream()));
    }

    static class StockInfo {
        public final String ticker;
        public final double price;

        public StockInfo(final String symbol, final double thePrice) {
            ticker = symbol;
            price = thePrice;
        }

        public String toString() {
            return String.format("ticker: %s price: %g", ticker, price);
        }
    }

    static class StockUtil {
        public static StockInfo getPrice(final String ticker) {
            return new StockInfo(ticker,
                    YahooFinance.getPrice(ticker, false)); // go through the code on agiledeveloper.com
        }

        public static Predicate<StockInfo> isPriceLessThan(final double price) {
            return stockInfo -> stockInfo.price < price;
        }

        public static StockInfo pickHigh(final StockInfo stockInfo1, final StockInfo stockInfo2) {
            return stockInfo1.price > stockInfo2.price ? stockInfo1 : stockInfo2;
        }
    }

    static class YahooFinance {
        public static double getPrice(final String ticker, boolean value) {
            return 320.00;
        }
    }
}