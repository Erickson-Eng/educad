package br.edu.ifpb.educad.service.postgresql;

import br.edu.ifpb.educad.dto.request.RegisterForm;
import br.edu.ifpb.educad.repository.UserRepository;
import br.edu.ifpb.educad.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServicePostgresql implements UserService {

    private UserRepository userRepository;
    @Override
    public void registerUser(RegisterForm registerForm) {

    }
}
