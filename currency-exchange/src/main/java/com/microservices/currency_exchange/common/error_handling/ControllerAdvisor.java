package com.microservices.currency_exchange.common.error_handling;

import com.microservices.currency_exchange.common.ErrorResponse;
import com.microservices.currency_exchange.common.error_handling.custom_exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(
            DataNotFoundException ex, WebRequest request) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "ErrCannotGet", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CannotCreateException.class)
    public ResponseEntity<Object> handleCannotCreateException(
            CannotCreateException ex, WebRequest request) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "ErrCannotCreate", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CannotListException.class)
    public ResponseEntity<Object> handleCannotListException(
            DataNotFoundException ex, WebRequest request) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "ErrCannotList", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CannotUpdateException.class)
    public ResponseEntity<Object> handleCannotUpdateException(
            CannotUpdateException ex, WebRequest request) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "ErrCannotUpdate", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CannotDeleteException.class)
    public ResponseEntity<Object> handleCannotDeleteException(
            CannotDeleteException ex, WebRequest request) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "ErrCannotDelete", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<Object> handleInvalidRequestException(
            InvalidRequestException ex, WebRequest request) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "ErrInvalidRequest", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
