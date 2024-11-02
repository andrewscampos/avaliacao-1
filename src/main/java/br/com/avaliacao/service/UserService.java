package br.com.avaliacao.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.avaliacao.exception.UserAlreadyExistsException;
import br.com.avaliacao.model.User;
import br.com.avaliacao.model.repository.UserRepository;
import br.com.avaliacao.request.RegisterUserRequest;
import br.com.avaliacao.response.UserResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class UserService {
	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	public List<UserResponse> allUsers() {
		List<User> users = new ArrayList<>();

		userRepository.findAll().forEach(users::add);

		return users.stream()
				.map(a -> UserResponse.builder().id(a.getId()).email(a.getEmail()).fullName(a.getEmail()).build())
				.toList();
	}

	public User save(RegisterUserRequest input) {
		if (userRepository.existsByEmail(input.getEmail())) {
			throw new UserAlreadyExistsException("E-mail já está em uso.");
		}
		User user = User.builder().fullName(input.getFullName()).email(input.getEmail()).password(input.getPassword())
				.build();

		return userRepository.save(user);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow();
	}

	@Transactional
	public UserResponse register(RegisterUserRequest request) {
		request.setPassword(passwordEncoder.encode(request.getPassword()));
		User user = save(request);
		return UserResponse.builder().email(user.getEmail()).id(user.getId()).fullName(user.getFullName()).build();
	}
}
