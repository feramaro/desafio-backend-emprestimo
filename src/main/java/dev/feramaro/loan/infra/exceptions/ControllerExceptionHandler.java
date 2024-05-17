package dev.feramaro.loan.infra.exceptions;

import dev.feramaro.loan.infra.exceptions.DTOs.FieldErrorDTO;
import dev.feramaro.loan.infra.exceptions.DTOs.ValidationErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorDTO handle(MethodArgumentNotValidException ex) {
        List<FieldErrorDTO> errors = new ArrayList<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        fieldErrors.forEach(error -> {
           errors.add(new FieldErrorDTO(error.getField(), error.getDefaultMessage()));
        });

       return new ValidationErrorDTO("Validation error", new Date().getTime(), errors);
    }
}
