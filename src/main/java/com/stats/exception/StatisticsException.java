package com.stats.exception;

public class StatisticsException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public StatisticsException() {
        super();
    }
    
    public StatisticsException(String message) {
        super(message);
    }
    
    public StatisticsException(String message, Throwable cause) {
        super(message, cause);
    }
}
