package com.stats;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CentralTendency {

    public double mean(double... _data) {
        double sum = 0;
        for (double datum : _data) {
            sum += datum;
        }
        return sum / _data.length;
    }

    public double median(double... _data) {
        int n = _data.length;
        double[] data = Arrays.stream(_data).parallel().sorted().toArray();
        int midIndex = n / 2;
        if (n % 2 == 0) {
            int i = midIndex;
            return (data[i] + data[i + 1]) / 2;
        } else {
            return data[midIndex];
        }
    }

    public Double mode(double... _data) {
        Double mode = null;
        Map<Double, Integer> keyCountMap = new HashMap<Double, Integer>();
        for (int i = 0; i < _data.length; i++) {
            if (!keyCountMap.containsKey(_data[i])) {
                keyCountMap.put(_data[i], 0);
            } else {
                int val = keyCountMap.get(_data[i]);
                keyCountMap.put(_data[i], ++val);
            }
        }
        return mode;
    }
    
}
