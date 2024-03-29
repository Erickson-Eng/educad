package br.edu.ifpb.educad.service;

import br.edu.ifpb.educad.dto.request.CourseRequest;
import br.edu.ifpb.educad.dto.response.CourseResponse;

import java.util.List;

public interface CourseService {

    List<CourseResponse> list();

    CourseResponse save(CourseRequest courseRequest);

    CourseResponse update(Long id, CourseRequest courseRequest);

    CourseResponse getCourseById(Long id);

    CourseResponse delete(Long id);

}
