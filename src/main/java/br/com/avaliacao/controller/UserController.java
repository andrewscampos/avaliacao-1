package br.com.avaliacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.avaliacao.model.User;
import br.com.avaliacao.request.RegisterUserRequest;
import br.com.avaliacao.response.UserResponse;
import br.com.avaliacao.service.UserService;

@RequestMapping("/users")
@RestController
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<UserResponse> register(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
		UserResponse signup = userService.register(registerUserRequest);
		return ResponseEntity.ok(signup);
	}

	@GetMapping("/me")
	public ResponseEntity<UserResponse> authenticatedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		User currentUser = (User) authentication.getPrincipal();

		UserResponse userResponse = UserResponse.builder().id(currentUser.getId()).email(currentUser.getEmail())
				.fullName(currentUser.getEmail()).build();

		return ResponseEntity.ok(userResponse);
	}

	@GetMapping("/")
	public ResponseEntity<List<UserResponse>> allUsers() {
		return ResponseEntity.ok(userService.allUsers());
	}
}