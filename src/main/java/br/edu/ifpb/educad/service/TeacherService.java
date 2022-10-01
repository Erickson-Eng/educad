package br.edu.ifpb.educad.service;

import br.edu.ifpb.educad.dto.request.TeacherRequest;
import br.edu.ifpb.educad.dto.response.TeacherResponse;

import java.util.List;

public interface TeacherService {
    List<TeacherResponse> list();

    TeacherResponse save(TeacherRequest teacherRequest);

    TeacherResponse update(Long id, TeacherRequest teacherRequest);

    TeacherResponse delete(Long id);

    TeacherResponse getTeacherById(Long id);

    // getTeacherByName
}
