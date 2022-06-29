package com.co.pragma.serviceclientimageclean.infraestructure.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.co.pragma.serviceclientimageclean.domain.exceptions.ClientImageCreatedException;
import com.co.pragma.serviceclientimageclean.domain.exceptions.ClientImageNotFoundException;
import com.co.pragma.serviceclientimageclean.domain.exceptions.ClientImageUpdateException;
import com.co.pragma.serviceclientimageclean.domain.exceptions.ErrorResponse;
import com.mongodb.MongoException;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(ClientImageCreatedException.class)
	public ResponseEntity<ErrorResponse> notCreatedClientImage(ClientImageCreatedException clientImageCreatedException){
		return new ResponseEntity<>(ErrorResponse.builder().error("Imagen no registrada")
				.message(clientImageCreatedException.getMessage())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.timestamp(new Date().toString())
				.build(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ClientImageUpdateException.class)
	public ResponseEntity<ErrorResponse> notCreatedClientImage(ClientImageUpdateException clientImageUpdateException){
		return new ResponseEntity<>(ErrorResponse.builder().error("Imagen no actualizada")
				.message(clientImageUpdateException.getMessage())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.timestamp(new Date().toString())
				.build(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ClientImageNotFoundException.class)
	public ResponseEntity<ErrorResponse> notCreatedClientImage(ClientImageNotFoundException clientImageNotFoundException){
		return new ResponseEntity<>(ErrorResponse.builder().error("Imagen no encontrada")
				.message(clientImageNotFoundException.getMessage())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.timestamp(new Date().toString())
				.build(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleMissingRequestBody(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ErrorResponse.builder().error("Cuerpo de llamada no es válido"+ request.getDescription(false))
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getCause().toString())
                .timestamp(new Date().toString()).build(),HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(MongoException.class)
	public ResponseEntity<ErrorResponse> mongoDBException(MongoException mongoException){
		return new ResponseEntity<>(ErrorResponse.builder().error("Imagen no encontrada")
				.message(mongoException.getMessage())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.timestamp(new Date().toString())
				.build(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
