package br.edu.ifpb.educad.controller;

import br.edu.ifpb.educad.service.UserService;
import br.edu.ifpb.educad.dto.request.RegisterForm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/register")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegisterController {

    private UserService userService;

    @PostMapping
    public void registerUser(@Valid @RequestBody RegisterForm registerForm){
        userService.registerUser(registerForm);
    }

}
