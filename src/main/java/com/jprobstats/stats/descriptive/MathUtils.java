package com.jprobstats.stats.descriptive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathUtils {

    private MathUtils() {}

    public static double sumOfSquares(double[] values) {
        values = evaluateData(values);
        double sumOfSquare = 0;
        for (int i = 0; i < values.length; i++) {
            sumOfSquare += Math.pow(values[i], 2);
        }
        return sumOfSquare;
    }

    private static double[] evaluateData(double[] values) {
        double[] validNum = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            if (!Double.isNaN(values[i])) {
                validNum[i] = values[i];
            }
        }
        return validNum;
    }

    public static double median(double[] values) {
        double median = 0;
        double[] validNum = evaluateData(values);

        List<Double> list = new ArrayList<>();
        for (int i = 0; i < validNum.length; i++) {
            list.add(validNum[i]);
        }
        Collections.sort(list);

        int rem = list.size() % 2;

        if (rem == 0) {
            if (list.size() >= 2) {
                int index = list.get(list.size() / 2).intValue();
                median = (list.get(index) + list.get(index - 1)) / 2;
            } else
                median = 0;
        } else {
            if (list.size() == 1) {
                median = list.get(0).doubleValue();
            } else {
                median = list.get(list.size() - 1 / 2);
            }
        }
        return median;
    }
}
