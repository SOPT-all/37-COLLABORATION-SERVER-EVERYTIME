package com.everytime.global.response;

import com.everytime.global.exception.constant.ErrorCode;

public record BaseErrorResponse(int status, String code, String msg) {

    public static BaseErrorResponse of(ErrorCode errorCode) {
        return new BaseErrorResponse(
                errorCode.getHttpStatus(),
                errorCode.getCode(),
                errorCode.getMsg()
        );
    }
}
