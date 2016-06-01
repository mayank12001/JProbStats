package com.stats;

public class StatsUtil {

    public static double max(double[] data) {
        int l = data.length;
        double max = data[0];
        int i = 0;
        if (l % 2 == 1) {
            i = 1;
        }

        for (; i < l; i += 2) {
            if (data[i] > data[i + 1]) {
                if (data[i] > max) {
                    max = data[i];
                }
            } else {
                if (data[i + 1] > max) {
                    max = data[i + 1];
                }
            }
        }
        return max;
    }

    public static double min(double[] data) {
        int l = data.length;
        double min = data[0];
        int i = 0;
        if (l % 2 == 1) {
            i = 1;
        }

        for (; i < l; i += 2) {
            if (data[i] < data[i + 1]) {
                if (data[i] < min) {
                    min = data[i];
                }
            } else {
                if (data[i + 1] < min) {
                    min = data[i + 1];
                }
            }
        }
        return min;
    }
}
