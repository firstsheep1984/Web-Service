package ca.yy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PassengerRestExceptionHandler {
	
	// Add exception handling code
	
	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<PassengerErrorResponse> handleException(PassengerNotFoundException exception){
		
		// Create a StudentErrorResponse
		PassengerErrorResponse error = new PassengerErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// Return ResponseEntity
		return new ResponseEntity<PassengerErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	// Add a generic exception handler
	@ExceptionHandler
	public ResponseEntity<PassengerErrorResponse> handleException(Exception exception){
		
		// Create a StudentErrorResponse
		PassengerErrorResponse error = new PassengerErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// Return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
