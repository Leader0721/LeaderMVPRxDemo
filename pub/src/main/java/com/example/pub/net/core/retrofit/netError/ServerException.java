package com.example.pub.net.core.retrofit.netError;

/**
 * 服务器返回的错误异常
 */
public class ServerException  extends RuntimeException {

    public String code;
    public String message;

    public ServerException(String code, String message) {
        super(message);
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

    @Override
    public String toString() {
        return code + "," + message;
    }
}
