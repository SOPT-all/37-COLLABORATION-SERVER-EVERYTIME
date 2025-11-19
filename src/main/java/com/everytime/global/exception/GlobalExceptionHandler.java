package com.everytime.global.exception;

import com.everytime.global.exception.constant.ErrorCode;
import com.everytime.global.exception.constant.GlobalErrorCode;
import com.everytime.global.response.BaseErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 커스텀 예외 처리
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<BaseErrorResponse> handlerCustomException(CustomException ex) {
        ErrorCode errorCode = ex.getErrorCode();
        log.error("[ERROR - CustomException] {}", errorCode.getMsg(), ex);
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(BaseErrorResponse.of(errorCode));
    }

    // 모든 예외
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseErrorResponse> handlerInternalServerError(Exception ex) {
        log.error("[ERROR - Unknown Exception]", ex);
        return ResponseEntity.status(GlobalErrorCode.INTERNAL_SERVER_ERROR.getHttpStatus())
                .body(BaseErrorResponse.of(GlobalErrorCode.INTERNAL_SERVER_ERROR));
    }

    // 타입 불일치
    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<BaseErrorResponse> handleTypeMismatch(TypeMismatchException ex) {
        log.error("[ERROR - TypeMismatchException]", ex);
        return ResponseEntity
                .status(GlobalErrorCode.TYPE_MISMATCH.getHttpStatus())
                .body(BaseErrorResponse.of(GlobalErrorCode.TYPE_MISMATCH));
    }

    // JSON 파싱 실패
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<BaseErrorResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        log.error("[ERROR - HttpMessageNotReadableException]", ex);
        return ResponseEntity.status(GlobalErrorCode.INVALID_JSON.getHttpStatus())
                .body(BaseErrorResponse.of(GlobalErrorCode.INVALID_JSON));
    }
}
