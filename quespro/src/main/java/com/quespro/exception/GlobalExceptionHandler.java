package com.quespro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

public class GlobalExceptionHandler {
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ApiResponse> handleValidationException(MethodArgumentNotValidException ex) {
	        ApiResponse response = new ApiResponse(400, "Invalid input: " + ex.getBindingResult().getFieldError().getDefaultMessage());
	        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	    }

	    // Handle 405 - Method Not Allowed
	    @ExceptionHandler(NoHandlerFoundException.class)
	    public ResponseEntity<ApiResponse> handleMethodNotAllowed(NoHandlerFoundException ex) {
	        ApiResponse response = new ApiResponse(405, "Invalid HTTP Method: " + ex.getHttpMethod());
	        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
	    }

	    // Handle 500 - Internal Server Error
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ApiResponse> handleGeneralException(Exception ex) {
	        ApiResponse response = new ApiResponse(500, "An unexpected error occurred. Please try again.");
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

}
