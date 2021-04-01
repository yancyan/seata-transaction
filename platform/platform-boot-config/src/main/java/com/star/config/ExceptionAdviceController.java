package com.star.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author ZhuYX
 * @date 2021/03/24
 */
@ControllerAdvice
public class ExceptionAdviceController extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<Object> handleOtherException(Exception ex, WebRequest request) {
        logger.error("Unexpected OtherException error: " + ex.getMessage(), ex);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(ex, ex.getMessage(),
                headers,
                HttpStatus.INTERNAL_SERVER_ERROR,
                request);
    }
}
