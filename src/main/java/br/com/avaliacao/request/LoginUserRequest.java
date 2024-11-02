package br.com.avaliacao.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginUserRequest {

	@NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
	private String email;

	@NotBlank(message = "A senha é obrigatória.")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
	private String password;
}
