/*package com.jprobstats.stats.descriptive;

import com.jprobstats.stats.utils.ResizableDoubleArray;

public class Statistics {
    
    
    *//**
     *  Stored data values
     *//*
    private ResizableDoubleArray eDA;
    
    private final UnivariateStatistic maxImpl = new Maximum();
    private final UnivariateStatistic minImpl = new Minimum();
    private final UnivariateStatistic sumImpl = new Sum();
    

 
    public Statistics() {
        eDA = new ResizableDoubleArray();
    }
    
    public void addValue(double v) {
       
        eDA.addElement(v);
        
    }
    public void addElements(double[] values) {
        
        eDA.addElements(values);
        
    }

    public double getMax() throws Exception {
        return apply(maxImpl);
    }

    public double getMin() throws Exception {
        return apply(minImpl);
    }
    
    public double getSum() throws Exception {
        return apply(sumImpl);
    }
    
    public double apply(UnivariateStatistic stat) throws Exception {
        return eDA.compute(stat);
    }
}
*/