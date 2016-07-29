package com.jprobstats.stats.descriptive;

import com.jprobstats.stats.utils.MathUtils;

public class Mean implements UnivariateStatistic {

    private Sum sum = new Sum();

    @Override
    public double evaluate(double[] values) throws Exception {
        double[] evalValue = MathUtils.evaluateData(values);
        double computedSum = sum.evaluate(evalValue);
        double mean = computedSum / values.length;
        return mean;
    }

}
