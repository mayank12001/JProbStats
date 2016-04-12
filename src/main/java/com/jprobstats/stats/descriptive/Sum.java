package com.jprobstats.stats.descriptive;

public class Sum implements UnivariateStatistic {
    @Override
    public double evaluate(double[] values) throws Exception {
        double sum = 0;
            for (int i = 0; i <values.length; i++) {
                if (!Double.isNaN(values[i])) {
                    sum +=values[i];
                }
            }
        return sum;
    }


}
