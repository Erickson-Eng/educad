package br.edu.ifpb.educad.service.postgresql;

import br.edu.ifpb.educad.dto.mapper.InstitutionMapper;
import br.edu.ifpb.educad.dto.request.InstitutionRequest;
import br.edu.ifpb.educad.dto.response.InstitutionResponse;
import br.edu.ifpb.educad.entity.Institution;
import br.edu.ifpb.educad.repository.InstitutionRepository;
import br.edu.ifpb.educad.service.InstitutionService;
import br.edu.ifpb.educad.service.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class InstitutionServicePostgresql implements InstitutionService {
    private InstitutionRepository institutionRepository;
    private InstitutionMapper institutionMapper;
    private AddressServicePostgresql addressServicePostgresql;

    @Override
    public InstitutionResponse save(InstitutionRequest institutionRequest) {
        Institution institution = institutionMapper.institutionRequestToEntity(institutionRequest);

        try {
            institutionRepository.save(institution);
        } catch (RuntimeException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }

        return institutionMapper.entityToInstitutionResponse(institution);
    }

    @Override
    public InstitutionResponse update(Long id, InstitutionRequest institutionRequest) {
        Institution institution = verifyIfExist(id);

        Long addressId = institution.getAddress().getId();

        updateData(institution, institutionRequest);
        addressServicePostgresql.update(addressId, institutionRequest.getAddressRequest());

        institutionRepository.save(institution);

        return institutionMapper.entityToInstitutionResponse(institution);
    }

    @Override
    public InstitutionResponse delete(Long id) {
        Institution institution = verifyIfExist(id);

        institutionRepository.delete(institution);

        return institutionMapper.entityToInstitutionResponse(institution);
    }

    @Override
    public InstitutionResponse getInstitutionById(Long id) {
        Institution institution = verifyIfExist(id);

        return institutionMapper.entityToInstitutionResponse(institution);
    }

    @Override
    public List<InstitutionResponse> getInstitutionByName(String name) {
        // Primeiro resolver erro do verifyIfExist para nome nos outros serviços
        return null;
    }

    protected Institution verifyIfExist(Long id) {
        return institutionRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("ID: %s || Não foi encontrado nenhuma entidade para o id fornecido", id))
        );
    }

    protected void updateData(Institution institution, InstitutionRequest institutionRequest) {
        institution.setName(institutionRequest.getName());
    }
}
