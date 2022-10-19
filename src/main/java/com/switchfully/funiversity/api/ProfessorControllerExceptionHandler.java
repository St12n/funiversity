package com.switchfully.funiversity.api;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ProfessorControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProfessorAlreadyExists.class)
    protected void professorExistsException(ProfessorAlreadyExists exception, HttpServletResponse response) throws IOException {
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }
}
