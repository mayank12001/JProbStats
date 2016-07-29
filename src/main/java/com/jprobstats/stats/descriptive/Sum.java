package com.jprobstats.stats.descriptive;

import com.jprobstats.stats.utils.MathUtils;

public class Sum implements UnivariateStatistic {
    @Override
    public double evaluate(double[] values) throws Exception {
        double sum = 0;
        double[] evalValue = MathUtils.evaluateData(values);
        for (int i = 0; i < evalValue.length; i++) {
            sum += evalValue[i];
        }
        return sum;
    }


}
