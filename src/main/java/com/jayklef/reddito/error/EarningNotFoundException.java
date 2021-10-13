package com.jayklef.reddito.error;

public class EarningNotFoundException extends Exception{
    public EarningNotFoundException() {
        super();
    }

    public EarningNotFoundException(String message) {
        super(message);
    }

    public EarningNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EarningNotFoundException(Throwable cause) {
        super(cause);
    }

    protected EarningNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
