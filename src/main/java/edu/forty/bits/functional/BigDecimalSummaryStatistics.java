package edu.forty.bits.functional;


import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collector;

/**
 * Like {@code DoubleSummaryStatistics}, {@code IntSummaryStatistics}, and
 * {@code LongSummaryStatistics}, but for {@link BigDecimal}.
 */
public class BigDecimalSummaryStatistics implements Consumer<BigDecimal> {

    public static Collector<BigDecimal, ?, BigDecimalSummaryStatistics> statistics() {
        return Collector.of(BigDecimalSummaryStatistics::new,
                BigDecimalSummaryStatistics::accept, BigDecimalSummaryStatistics::merge);
    }

    private BigDecimal sum = BigDecimal.ZERO, min, max;
    private long count;

    public void accept(BigDecimal t) {
        if (count == 0) {
            Objects.requireNonNull(t);
            count = 1;
            sum = t;
            min = t;
            max = t;
        } else {
            sum = sum.add(t);
            if (min.compareTo(t) > 0) min = t;
            if (max.compareTo(t) < 0) max = t;
            count++;
        }
    }

    private BigDecimalSummaryStatistics merge(BigDecimalSummaryStatistics s) {
        if (s.count > 0) {
            if (count == 0) {
                count = s.count;
                sum = s.sum;
                min = s.min;
                max = s.max;
            } else {
                sum = sum.add(s.sum);
                if (min.compareTo(s.min) > 0) min = s.min;
                if (max.compareTo(s.max) < 0) max = s.max;
                count += s.count;
            }
        }
        return this;
    }

    public long getCount() {
        return count;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public BigDecimal getAverage(MathContext mc) {
        return count < 2 ? sum : sum.divide(BigDecimal.valueOf(count), mc);
    }

    public BigDecimal getMin() {
        return min;
    }

    public BigDecimal getMax() {
        return max;
    }

    @Override
    public String toString() {
        return count == 0 ? "empty" : (count + " elements between " + min + " and " + max + ", sum=" + sum);
    }
}