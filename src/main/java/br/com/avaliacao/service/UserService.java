package br.com.avaliacao.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.avaliacao.exception.UserAlreadyExistsException;
import br.com.avaliacao.mapper.UserMappper;
import br.com.avaliacao.model.User;
import br.com.avaliacao.model.repository.UserRepository;
import br.com.avaliacao.request.UserRequest;
import br.com.avaliacao.response.UserResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;
	
	private final UserMappper userMappper;

	public List<UserResponse> allUsers() {
		List<User> users = new ArrayList<>();

		userRepository.findAll().forEach(users::add);

		return users.stream()
				.map(a -> userMappper.toResponse(a))
				.toList();
	}

	public User save(UserRequest input) {
		if (userRepository.existsByEmail(input.getEmail())) {
			throw new UserAlreadyExistsException("E-mail já está em uso.");
		}
		User user = userMappper.toUser(input);
		return userRepository.save(user);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow();
	}

	@Transactional
	public UserResponse register(UserRequest request) {
		request.setPassword(passwordEncoder.encode(request.getPassword()));
		User user = save(request);
		return userMappper.toResponse(user);
	}
}
