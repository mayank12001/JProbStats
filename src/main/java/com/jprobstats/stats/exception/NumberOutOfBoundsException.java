package com.jprobstats.stats.exception;

public class NumberOutOfBoundsException extends RuntimeException {

    private static final long serialVersionUID = -5188917868492402363L;

    /**
     * Constructs an <code>NumberOutOfBoundsException</code> with no detail message.
     */
    public NumberOutOfBoundsException() {
        super();
    }

    /**
     * Constructs an <code>NmberOutOfBoundsException</code> with the specified detail message.
     *
     * @param s the detail message.
     */
    public NumberOutOfBoundsException(String s) {
        super(s);
    }

}
