package br.edu.ifpb.educad.dto.mapper;

import br.edu.ifpb.educad.dto.request.TeacherRequest;
import br.edu.ifpb.educad.dto.response.TeacherResponse;
import br.edu.ifpb.educad.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface TeacherMapper {
    @Mapping(target = "user.id", source = "userId")
    Teacher teacherRequestToEntity(TeacherRequest teacherRequest);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "addressResponse", source = "address")
    TeacherResponse entityToTeacherResponse(Teacher teacher);
}
