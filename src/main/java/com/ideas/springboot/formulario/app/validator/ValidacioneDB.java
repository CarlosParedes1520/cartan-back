package com.ideas.springboot.formulario.app.validator;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ValidacioneDB  {
	// validacion de llaves existentes en la base de datos
	 @ResponseStatus(code=HttpStatus.CONFLICT)
	    @ExceptionHandler(DataIntegrityViolationException.class)
	    public String handleDataIntegrityViolation(DataIntegrityViolationException ex) {
	        return "El codigo ya existe en la base de datos.";
	    }
}
