package br.edu.ifpb.educad.service.postgresql;

import br.edu.ifpb.educad.dto.mapper.UserMapper;
import br.edu.ifpb.educad.dto.request.RegisterForm;
import br.edu.ifpb.educad.dto.response.UserResponse;
import br.edu.ifpb.educad.entity.User;
import br.edu.ifpb.educad.repository.UserRepository;
import br.edu.ifpb.educad.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServicePostgresql implements UserService {
    private UserMapper userMapper;
    private UserRepository userRepository;

    @Override
    public UserResponse registerUser(RegisterForm registerForm) {
        User user = userMapper.userRequestToEntity(registerForm);

        try {
            userRepository.save(user);
        } catch (RuntimeException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }

        UserResponse userResponse = userMapper.entityToUserResponse(user);

        return userResponse;
    }
}
