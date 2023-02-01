package br.edu.ifpb.educad.service;

import br.edu.ifpb.educad.dto.request.ClassRequest;
import br.edu.ifpb.educad.dto.response.ClassResponse;

public interface ClassService {
    ClassResponse save(ClassRequest classRequest);

    ClassResponse update(Long id, ClassRequest classRequest);

    ClassResponse delete(Long id);

    ClassResponse getClassById(Long id);
}
