package br.edu.ifpb.educad.dto.mapper;

import br.edu.ifpb.educad.dto.request.StudentRequest;
import br.edu.ifpb.educad.dto.response.StudentResponse;
import br.edu.ifpb.educad.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface StudentMapper {

    @Mapping(target = "user.id", source = "userId")
    Student studentRequestToEntity(StudentRequest studentRequest);

    @Mapping(source = "user.id", target = "userId")
    StudentResponse entityToStudentResponse(Student student);
}
