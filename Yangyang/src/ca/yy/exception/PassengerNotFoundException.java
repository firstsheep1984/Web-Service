package ca.yy.exception;

// Step 2
public class PassengerNotFoundException extends RuntimeException{

	public PassengerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PassengerNotFoundException(String message) {
		super(message);
	}

	public PassengerNotFoundException(Throwable cause) {
		super(cause);
	}
}
