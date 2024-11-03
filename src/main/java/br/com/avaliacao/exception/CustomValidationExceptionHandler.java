package br.com.avaliacao.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomValidationExceptionHandler {

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = generateResponse(ex);
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ UserAlreadyExistsException.class })
	public ResponseEntity<Map<String, String>> userAlreadyExistsException(UserAlreadyExistsException ex) {
		Map<String, String> errors = generateResponse(ex);
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	private Map<String, String> generateResponse(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	private Map<String, String> generateResponse(UserAlreadyExistsException ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("error", ex.getMessage());
		return errors;
	}

}
