package br.edu.ifpb.educad.service;

import br.edu.ifpb.educad.dto.request.StudentRequest;
import br.edu.ifpb.educad.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse save(StudentRequest studentRequest);

    StudentResponse update(Long id, StudentRequest studentRequest);

    StudentResponse delete(Long id);

    StudentResponse getStudentById(Long id);

    List<StudentResponse> getStudentByName(String name);


}
