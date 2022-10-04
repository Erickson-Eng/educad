package br.edu.ifpb.educad.dto.mapper;

import br.edu.ifpb.educad.dto.request.CourseRequest;
import br.edu.ifpb.educad.dto.response.CourseResponse;
import br.edu.ifpb.educad.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(target = "id", ignore = true)
    Course courseRequestToEntity(CourseRequest courseRequest);

    @Mapping(source = "institution.name", target = "institutionName")
    CourseResponse entityToCourseResponse(Course course);

}
