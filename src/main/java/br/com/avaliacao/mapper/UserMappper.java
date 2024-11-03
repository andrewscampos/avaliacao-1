package br.com.avaliacao.mapper;

import org.mapstruct.Mapper;

import br.com.avaliacao.model.User;
import br.com.avaliacao.request.UserRequest;
import br.com.avaliacao.response.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMappper {

	UserResponse toResponse(User user);
 
	User toUser(UserRequest registerUserRequest);
}
