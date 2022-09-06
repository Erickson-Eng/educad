package br.edu.ifpb.educad.controller;

import br.edu.ifpb.educad.config.security.TokenService;
import br.edu.ifpb.educad.config.security.UserSecurity;
import br.edu.ifpb.educad.dto.request.LoginForm;
import br.edu.ifpb.educad.dto.response.TokenResponse;
import br.edu.ifpb.educad.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> auth(@RequestBody @Valid LoginForm loginForm){
        UsernamePasswordAuthenticationToken login = loginForm.usernameAndPasswordToToken();
        try {
            Authentication authentication = authenticationManager.authenticate(login);
            String token = tokenService.generateToken(authentication);

            return ResponseEntity.ok().body(new TokenResponse(token, "Bearer"));
        } catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
