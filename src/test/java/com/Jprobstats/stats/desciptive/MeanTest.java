package com.Jprobstats.stats.desciptive;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jprobstats.stats.descriptive.Mean;

public class MeanTest {
    @Test
    public void test_evaluate() throws Exception {
        double[] data = new double[3];
        data[0] = -2;
        data[1] = -4;
        data[2] = -6;
        Mean mean = new Mean();
        assertEquals(mean.evaluate(data), -4, 0.001);
    }

    @Test
    public void test_evaluate_NAN() throws Exception {
        double[] data = new double[3];
        data[0] = 2;
        data[1] = 4;
        data[2] = Double.NaN;
        Mean mean = new Mean();
        assertEquals(mean.evaluate(data), 2, 0.001);
    }
}

