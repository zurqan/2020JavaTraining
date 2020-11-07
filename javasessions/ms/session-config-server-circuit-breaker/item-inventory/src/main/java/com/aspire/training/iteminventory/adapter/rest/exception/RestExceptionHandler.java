package com.aspire.training.iteminventory.adapter.rest.exception;

import com.aspire.training.iteminventory.exceptions.AbstractTrainingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class RestExceptionHandler {

    private final AllErrorMessages allErrorMessages;

    public RestExceptionHandler(AllErrorMessages allErrorMessages) {
        this.allErrorMessages = allErrorMessages;
    }

    @ExceptionHandler(AbstractTrainingException.class)
    public ResponseEntity<Object> handleTrainingException(AbstractTrainingException e) {

        ErrorInfo errorInfo = allErrorMessages
                .byClass(e)
                .orElseGet(() -> generalErrorInfo(e));

        return new ResponseEntity<>(errorInfo, new HttpHeaders(), HttpStatus.resolve(errorInfo.getRestStatus()));

    }

    private ErrorInfo generalErrorInfo(RuntimeException e) {

        return ErrorInfo
                .builder()
                .errorCode(0)
                .restStatus(HttpStatus.BAD_REQUEST.value())
                .msgs(new HashMap() {{
                    put(Lang.AR, "خطأ عام" + e.getMessage());
                    put(Lang.ENG, e.getMessage());
                }})
                .build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleGeneralException(RuntimeException e) {

        ErrorInfo errorInfo = generalErrorInfo(e);
        return new ResponseEntity<>(errorInfo, new HttpHeaders(), HttpStatus.resolve(errorInfo.getRestStatus()));


    }
}
