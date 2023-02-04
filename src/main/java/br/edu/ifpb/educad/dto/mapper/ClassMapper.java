package br.edu.ifpb.educad.dto.mapper;

import br.edu.ifpb.educad.dto.request.ClassRequest;
import br.edu.ifpb.educad.dto.response.ClassResponse;
import br.edu.ifpb.educad.entity.Class;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "teacherId", target = "teacher.id")
    Class classRequestToEntity(ClassRequest classRequest);

    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "teacher.id", target = "teacherId")
    ClassResponse entityToClassResponse(Class classEntity);

}
