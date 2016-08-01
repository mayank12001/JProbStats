package com.jprobstats.stats.descriptive;

import com.jprobstats.stats.utils.MathUtils;

public class StatisticsUtils {

    private StatisticsUtils() {}


    public static double computeSum(double[] values) throws Exception {
        double sum = 0;
        double[] evalValue = MathUtils.evaluateData(values);
        for (int i = 0; i < evalValue.length; i++) {
            sum += evalValue[i];
        }
        return sum;
    }

    public static double computeMean(double[] values) throws Exception {
        double computedSum = computeSum(values);
        double mean = computedSum / values.length;
        return mean;
    }

    public static double computeStdDev(double[] values) throws Exception {
        double computedMean = computeMean(values);
        double[] comValue = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            if (!Double.isNaN(values[i])) {
                comValue[i] = values[i] - computedMean;
            }
        }
        double stdDev = Math.sqrt(MathUtils.sumOfSquares.apply(comValue) / comValue.length);

        return stdDev;
    }
    
    public static double evaluate(double[] values) throws Exception {
        return Math.pow(computeStdDev(values), 2);
    }
}
