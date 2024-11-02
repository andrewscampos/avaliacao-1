package br.com.avaliacao.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.avaliacao.model.User;
import br.com.avaliacao.request.LoginUserRequest;
import br.com.avaliacao.response.LoginResponse;
import br.com.avaliacao.service.AuthenticationService;
import br.com.avaliacao.service.JwtService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/token")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody @Valid LoginUserRequest loginUserRequest) {
        User user = authenticationService.authenticate(loginUserRequest);

        String jwtToken = jwtService.generateToken(user);

        LoginResponse loginResponse = LoginResponse.builder().token(jwtToken).expiresIn(jwtService.getExpirationTime()).build();

        return ResponseEntity.ok(loginResponse);
    }
}
