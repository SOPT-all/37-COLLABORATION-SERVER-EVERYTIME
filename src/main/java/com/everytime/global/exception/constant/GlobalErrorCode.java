package com.everytime.global.exception.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum GlobalErrorCode implements ErrorCode {
    FILE_INIT_FAILED(HttpStatus.INTERNAL_SERVER_ERROR.value(), "FILE_INIT_FAILED", "파일 초기화를 실패했습니다."),
    FILE_UPDATE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR.value(), "FILE_UPDATE_FAILED", "데이터 파일 저장에 실패하였습니다."),
    INVALID_JSON(HttpStatus.BAD_REQUEST.value(), "INVALID_JSON", "잘못된 JSON 형식입니다."),
    TYPE_MISMATCH(HttpStatus.BAD_REQUEST.value(), "TYPE_MISMATCH", "요청 타입이 올바르지 않습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "INTERNAL_SERVER_ERROR", "서버 내부 오류가 발생했습니다.");

    private final int httpStatus;
    private final String code;
    private final String msg;


    GlobalErrorCode(int httpStatus, String code, String msg) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.msg = msg;
    }

}
