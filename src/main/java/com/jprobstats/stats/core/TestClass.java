package com.jprobstats.stats.core;

import com.jprobstats.stats.descriptive.Statistics;

public class TestClass {
    private static final double[] userData={3,6,2,1,5,8};
    
    public static void main(String[] args) throws Exception {
        
        Statistics stats = new Statistics();
        stats.addElements(userData);
        double max =stats.getMax();
        double min = stats.getMin();
        double sum = stats.getSum();
        System.out.println("MAX :: "+max+"\nMIN :: "+min+"\nSUM :: "+sum);

    }

}
