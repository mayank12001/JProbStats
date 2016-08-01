package com.jprobstats.stats.exception;

public class NumberIsTooSmallException extends MathIllegalArgumentException {

    private static final long serialVersionUID = -5025135681865637247L;

    public NumberIsTooSmallException(String message) {
        super(message);
    }

}
