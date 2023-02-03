package br.edu.ifpb.educad.service;

import br.edu.ifpb.educad.dto.response.SubjectResponse;

public interface SubjectService {
    SubjectResponse save(SubjectRequest subjectRequest);

    SubjectResponse update(Long id, SubjectRequest subjectRequest);

    SubjectResponse delete(Long id);

    SubjectResponse getSubjectById(Long id);
}
