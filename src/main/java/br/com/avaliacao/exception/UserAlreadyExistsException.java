package br.com.avaliacao.exception;

public class UserAlreadyExistsException extends RuntimeException {
	
    private static final long serialVersionUID = -5794137041809133038L;

	public UserAlreadyExistsException(String message) {
        super(message);
    }
}
