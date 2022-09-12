package br.edu.ifpb.educad.service.postgresql;

import br.edu.ifpb.educad.dto.mapper.InstitutionMapper;
import br.edu.ifpb.educad.dto.request.InstitutionRequest;
import br.edu.ifpb.educad.dto.response.InstitutionResponse;
import br.edu.ifpb.educad.repository.InstitutionRepository;
import br.edu.ifpb.educad.service.InstitutionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class InstitutionServicePostgresql implements InstitutionService {
    private InstitutionRepository institutionRepository;
    private InstitutionMapper institutionMapper;

    @Override
    public InstitutionResponse save(InstitutionRequest institutionRequest) {
        return null;
    }

    @Override
    public InstitutionResponse update(Long id, InstitutionRequest institutionRequest) {
        return null;
    }

    @Override
    public InstitutionResponse delete(Long id) {
        return null;
    }

    @Override
    public InstitutionResponse getInstitutionById(Long id) {
        return null;
    }

    @Override
    public List<InstitutionResponse> getInstitutionByName(String name) {
        return null;
    }
}
