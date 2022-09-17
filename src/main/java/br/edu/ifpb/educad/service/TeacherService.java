package br.edu.ifpb.educad.service;

import br.edu.ifpb.educad.dto.request.TeacherRequest;
import br.edu.ifpb.educad.dto.response.TeacherResponse;

public interface TeacherService {
    TeacherResponse save(TeacherRequest teacherRequest);

    TeacherResponse update(Long id, TeacherRequest teacherRequest);

    TeacherResponse delete(Long id);

    TeacherResponse getTeacherById(Long id);

    // getTeacherByName
}
