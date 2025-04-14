package com.spring.ProgettoDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.ProgettoDemo.dto.ErroreDTO;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GestoreErrori {
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> handler(RuntimeException exc){
		ErroreDTO error = new ErroreDTO(exc.getMessage());
		ResponseEntity<ErroreDTO> response = new ResponseEntity<ErroreDTO>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErroreDTO> handleNullPointerException(NullPointerException exc) {
	    ErroreDTO error = new ErroreDTO("Si è verificato un errore di tipo NullPointerException");
	    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
