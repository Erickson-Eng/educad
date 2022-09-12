package br.edu.ifpb.educad.service;

import br.edu.ifpb.educad.dto.request.InstitutionRequest;
import br.edu.ifpb.educad.dto.response.InstitutionResponse;

import java.util.List;

public interface InstitutionService {
    InstitutionResponse save(InstitutionRequest institutionRequest);

    InstitutionResponse update(Long id, InstitutionRequest institutionRequest);

    InstitutionResponse delete(Long id);

    InstitutionResponse getInstitutionById(Long id);

    List<InstitutionResponse> getInstitutionByName(String name);
}
