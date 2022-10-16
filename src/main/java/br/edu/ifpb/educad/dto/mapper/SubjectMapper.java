package br.edu.ifpb.educad.dto.mapper;

import br.edu.ifpb.educad.dto.request.SubjectRequest;
import br.edu.ifpb.educad.dto.response.SubjectResponse;
import br.edu.ifpb.educad.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    @Mapping(source = "teacherRequest", target = "teacher")
    Subject subjectRequestToEntity(SubjectRequest subjectRequest);

    @Mapping(source = "teacher", target = "teacherResponse")
    SubjectResponse entityToSubjectResponse(Subject subject);
}
