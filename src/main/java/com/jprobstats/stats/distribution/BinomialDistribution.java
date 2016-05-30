package com.jprobstats.stats.distribution;

import java.math.BigInteger;

import com.jprobstats.stats.utils.MathUtils;

public class BinomialDistribution {

    private final int noOfTrails;
    private final double probOfSuccess;

    public BinomialDistribution(int noOfTrails, double probabilityOfSuccess) {
        this.noOfTrails = noOfTrails;
        this.probOfSuccess = probabilityOfSuccess;
    }

    public double getProbOfSuccess() {
        return probOfSuccess;
    }

    public int getNoOfTrails() {
        return noOfTrails;
    }

    public double getProbability(int x) {
        if (noOfTrails == 0) {
            return (x == 0) ? 0. : Double.NEGATIVE_INFINITY;
        }
        double ret;
        if (x < 0 || x > noOfTrails) {
            ret = Double.NEGATIVE_INFINITY;
        } else {
            /*
             * ret = SaddlePointExpansion.logBinomialProbability(x, numberOfTrials,
             * probabilityOfSuccess, 1.0 - probabilityOfSuccess); }
             */

            BigInteger trailFact = MathUtils.computefactorial(noOfTrails);
            BigInteger xFact = MathUtils.computefactorial(x).multiply(MathUtils.computefactorial(noOfTrails - x));
            double numberOfOutcomes = trailFact.divide(xFact).doubleValue();
            double probTrails = Math.pow(probOfSuccess, x) * Math.pow(1 - probOfSuccess, noOfTrails - x);
            double output = numberOfOutcomes * probTrails;
            ret = output;
        }
        return ret;
    }

    public double getNumericalMean() {
        return noOfTrails * probOfSuccess;
    }

    public double getNumericalVariance() {
        final double p = probOfSuccess;
        return noOfTrails * p * (1 - p);
    }
}
