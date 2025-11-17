package com.everytime.global.exception.constant;

public interface ErrorCode {
    int getHttpStatus();
    String getCode();
    String getMsg();
}
