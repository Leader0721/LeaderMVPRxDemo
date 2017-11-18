package com.example.pub.net.core.retrofit.netError;

/**
 * APP异常
 */
public class ApiException extends Exception {
    private String code;
    private String message;
    private Throwable throwable;

    public ApiException(Throwable throwable, String code) {
        super(throwable);
        this.throwable = throwable;
        this.code = code;
    }

    public ApiException(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String toString() {
        return code + "," + message + "," + throwable.toString();
    }
}