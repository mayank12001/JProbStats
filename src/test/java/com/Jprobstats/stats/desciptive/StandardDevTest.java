package com.Jprobstats.stats.desciptive;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jprobstats.stats.descriptive.StandardDev;

public class StandardDevTest {

    @Test
    public void test_evaluate() throws Exception {
        double[] data = new double[3];
        data[0] = 2;
        data[1] = 4;
        data[2] = 6;
        StandardDev dev = new StandardDev();
        assertEquals(dev.evaluate(data), 1.634, 0.01);
    }

    @Test
    public void test_evaluate_NAN() throws Exception {
        double[] data = new double[3];
        data[0] = 2;
        data[1] = 4;
        data[2] = Double.NaN;
        StandardDev dev = new StandardDev();
        assertEquals(dev.evaluate(data), 1.154, 0.01);
    }
}
