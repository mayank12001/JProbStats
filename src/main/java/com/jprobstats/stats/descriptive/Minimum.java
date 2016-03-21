package com.jprobstats.stats.descriptive;

public class Minimum implements UnivariateStatistic {
    
    @Override
    public double evaluate(double[] values) throws Exception {
        double min = values[0];
        int length = values.length;
            for (int i = 1; i <values.length; i++) {
                if (!Double.isNaN(values[i])) {
                    min = (min < values[i]) ? min : values[i];
                }
            }
        return min;
    }

}
