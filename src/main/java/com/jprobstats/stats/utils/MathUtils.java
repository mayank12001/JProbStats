package com.jprobstats.stats.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.collections.IteratorUtils;

public class MathUtils {
    /** Archimede's constant PI, ratio of circle circumference to diameter. */
    public static final double PI = 105414357.0 / 33554432.0 + 1.984187159361080883e-9;

    /** Napier's constant e, base of the natural logarithm. */
    public static final double E = 2850325.0 / 1048576.0 + 8.254840070411028747e-8;

    public static final double TWO_PI = 2 * PI;

    public static final double PI_SQUARED = PI * PI;

    private MathUtils() {}

    public static Function<double[], Double> sumOfSquares = (value) -> {
        value = evaluateData(value);
        double sumOfSquare = 0;
        for (int i = 0; i < value.length; i++) {
            sumOfSquare += Math.pow(value[i], 2);
        }
        return sumOfSquare;
    };

    /**
     * Check weather
     * 
     * @param values
     * @return
     */
    public static double[] evaluateData(double[] values) {
        double[] validNum = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            if (!Double.isNaN(values[i])) {
                validNum[i] = values[i];
            }
        }
        return validNum;
    }

    public static double computeMedian(double[] values) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }
        return computeMedian(evaluateData(list));
    }

    public static double sumOfSquares(List<Double> values) {
        values = evaluateData(values);
        double sumOfSquare = 0;
        for (double value : values) {
            sumOfSquare += Math.pow(value, 2);
        }
        return sumOfSquare;
    }

    public static List<Double> evaluateData(List<Double> values) {
        List<Double> validNum = new ArrayList<>();
        for (double value : values) {
            if (!Double.isNaN(value)) {
                validNum.add(value);
            }
        }
        return validNum;
    }

    public static double computeMedian(Iterator<Double> iter) {
        List<Double> validNum = evaluateData(iter);
        List<Double> list = new ArrayList<>();
        for (double value : validNum) {
            list.add(value);
        }
        return computeMedian(list);
    }

    private static double computeMedian(List<Double> list) {
        double median = 0;
        Collections.sort(list);
        int rem = list.size() % 2;
        if (rem == 0) {
            if (list.size() >= 2) {
                int index = list.size() / 2;
                median = (list.get(index) + list.get(index - 1)) / 2;
            } else
                median = 0;
        } else {
            if (list.size() == 1) {
                median = list.get(0).doubleValue();
            } else {
                median = list.get((list.size() - 1) / 2);
            }
        }
        return median;

    }

    public static BigInteger computefactorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        BigInteger fact = BigInteger.valueOf(1);
        if (n == 0)
            return fact;

        for (int i = 1; i <= n; i++)
            fact = fact.multiply(BigInteger.valueOf(i));

        return fact;

    }

    public static List<Double> evaluateData(Iterator<Double> iter) {
        @SuppressWarnings("unchecked")
        List<Double> listValues = IteratorUtils.toList(iter);
        return evaluateData(listValues);
    }

}
