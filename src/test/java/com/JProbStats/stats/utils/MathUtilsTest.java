package com.JProbStats.stats.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jprobstats.stats.utils.MathUtils;


public class MathUtilsTest {

    @Test
    public void test_computefactorial() {
        assertEquals(MathUtils.computefactorial(19).doubleValue(), 1.21645100408832E17, 1);
        assertEquals(MathUtils.computefactorial(45).doubleValue(), 1.1962222086548019E56, 1);
        assertEquals(MathUtils.computefactorial(5).doubleValue(), 120, 1);
        assertEquals(MathUtils.computefactorial(0).doubleValue(), 1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_computefactorial_null() {
        assertEquals(MathUtils.computefactorial(-56).doubleValue(), 1.21645100408832E17, 1);

    }

    @Test
    public void test_sumOfSquares() {
        double[] data = new double[3];
        data[0] = 2;
        data[1] = Double.NaN;
        data[2] = 7;
        assertEquals(MathUtils.sumOfSquares.apply(data), 53, 0);
        List<Double> values = new ArrayList<>();
        values.add(new Double(3));
        values.add(new Double(4));
        values.add(Double.NaN);
        assertEquals(MathUtils.sumOfSquares(values), 25, 0);
    }

    @Test
    public void test_computeMedian() {
        double[] data = new double[3];
        data[0] = 2;
        data[1] = Double.NaN;
        data[2] = 7;
        assertEquals(MathUtils.computeMedian(data), 4.5, 0);

        List<Double> values = new ArrayList<>();
        assertEquals(MathUtils.computeMedian(values.iterator()), 0, 0);
        values.add(new Double(3));
        assertEquals(MathUtils.computeMedian(values.iterator()), 3, 0);
        values.add(new Double(4));
        assertEquals(MathUtils.computeMedian(values.iterator()), 3.5, 0);
        values.add(Double.NaN);
        assertEquals(MathUtils.computeMedian(values.iterator()), 3.5, 0);
        values.add(new Double(5));
        assertEquals(MathUtils.computeMedian(values.iterator()), 4, 0);
    }
}
