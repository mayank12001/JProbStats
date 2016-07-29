package com.jprobstats.stats.descriptive;

import com.jprobstats.stats.utils.MathUtils;

public class StandardDev implements UnivariateStatistic {
    private Mean mean = new Mean();

    @Override
    public double evaluate(double[] values) throws Exception {
        double computedMean = mean.evaluate(values);
        double[] comValue = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            if (!Double.isNaN(values[i])) {
                comValue[i] = values[i] - computedMean;
            }
        }
        if (comValue == null)
            throw new Exception("Invalid argument of double array");

        double stdDev = Math.sqrt(MathUtils.sumOfSquares.apply(comValue) / comValue.length);

        return stdDev;
    }
}
