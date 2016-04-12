package com.jprobstats.stats.descriptive;

public class Variance implements UnivariateStatistic {

    private StandardDev stdDev = new StandardDev();

    @Override
    public double evaluate(double[] values) throws Exception {
        return Math.pow(stdDev.evaluate(values), 2);
    }

}
