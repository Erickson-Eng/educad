package br.edu.ifpb.educad.dto.mapper;

import br.edu.ifpb.educad.dto.request.RegisterForm;
import br.edu.ifpb.educad.dto.response.UserResponse;
import br.edu.ifpb.educad.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    User userRequestToEntity(RegisterForm registerForm);

    UserResponse entityToUserResponse(User user);
}
