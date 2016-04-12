package com.jprobstats.stats.descriptive;



public interface UnivariateStatistic {
   
    /**
     * Returns the result of evaluating the statistic over the input array.
     *
     * @param values input array
     * @return the value of the statistic applied to the input array
     * @throws Exception  if values is null
     */
    double evaluate(double[] values) throws Exception;

    
}
