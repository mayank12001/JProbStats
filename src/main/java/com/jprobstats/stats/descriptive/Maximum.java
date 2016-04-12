package com.jprobstats.stats.descriptive;

public class Maximum implements UnivariateStatistic {

    @Override
    public double evaluate(double[] values) throws Exception {
        double max = Double.NaN;
            for (int i = 0; i <values.length; i++) {
                if (!Double.isNaN(values[i])) {
                    max = (max > values[i]) ? max : values[i];
                }
            }
        return max;
    }

}
