package com.jprobstats.stats.descriptive;

public class Mean implements UnivariateStatistic {

    private Sum sum = new Sum();

    @Override
    public double evaluate(double[] values) throws Exception {
        double computedSum = sum.evaluate(values);
        double mean = computedSum / values.length;
        return mean;
    }

}
