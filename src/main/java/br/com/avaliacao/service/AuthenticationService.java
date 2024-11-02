package br.com.avaliacao.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import br.com.avaliacao.model.User;
import br.com.avaliacao.request.LoginUserRequest;

@Service
public class AuthenticationService {
	private final UserService userService;


	private final AuthenticationManager authenticationManager;

	public AuthenticationService(UserService userService, AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
		this.userService = userService;
	}

	public User authenticate(LoginUserRequest input) {
		String email = input.getEmail();
		String password = input.getPassword();
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
		authenticationManager.authenticate(token);
		return userService.findByEmail(input.getEmail());
	}
}
