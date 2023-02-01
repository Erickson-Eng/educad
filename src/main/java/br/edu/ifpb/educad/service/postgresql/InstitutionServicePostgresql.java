package br.edu.ifpb.educad.service.postgresql;

import br.edu.ifpb.educad.dto.mapper.CourseMapper;
import br.edu.ifpb.educad.dto.mapper.InstitutionMapper;
import br.edu.ifpb.educad.dto.request.InstitutionRequest;
import br.edu.ifpb.educad.dto.response.CourseResponse;
import br.edu.ifpb.educad.dto.response.InstitutionResponse;
import br.edu.ifpb.educad.entity.Course;
import br.edu.ifpb.educad.entity.Institution;
import br.edu.ifpb.educad.repository.InstitutionRepository;
import br.edu.ifpb.educad.service.InstitutionService;
import br.edu.ifpb.educad.service.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class InstitutionServicePostgresql implements InstitutionService {
    private InstitutionRepository institutionRepository;
    private InstitutionMapper institutionMapper;
    private CourseMapper courseMapper;
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
        Institution institution = verifyIfExists(id);

        Long addressId = institution.getAddress().getId();

        updateData(institution, institutionRequest);
        addressServicePostgresql.update(addressId, institutionRequest.getAddressRequest());

        institutionRepository.save(institution);

        return institutionMapper.entityToInstitutionResponse(institution);
    }

    @Override
    public InstitutionResponse delete(Long id) {
        Institution institution = verifyIfExists(id);

        institutionRepository.delete(institution);

        return institutionMapper.entityToInstitutionResponse(institution);
    }

    @Override
    public InstitutionResponse getInstitutionById(Long id) {
        Institution institution = verifyIfExists(id);

        return institutionMapper.entityToInstitutionResponse(institution);
    }

    @Override
    public List<InstitutionResponse> getInstitutionByName(String name) {
        List<Institution> institutions = verifyIfExists(name);

        return listInstitutionToResponse(institutions);
    }

    protected Institution verifyIfExists(Long id) {
        return institutionRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("ID: %s || Não foi encontrado nenhuma entidade para o id fornecido", id))
        );
    }

    protected List<Institution> verifyIfExists(String name) {
        return institutionRepository.findInstitutionsByName(name).orElseThrow(
                () -> new EntityNotFoundException(String.format("Name: %s || Não foi encontrado nenhuma instituição para o nome informado", name))
        );
    }

    protected void updateData(Institution institution, InstitutionRequest institutionRequest) {
        institution.setName(institutionRequest.getName());
    }

    public List<CourseResponse> getCoursesByInstitution(Long id) {
        Institution institution = this.verifyIfExists(id);
        Optional<List<Course>> optionalSubjects = institutionRepository.getCoursesByInstitution(institution.getId());
        return optionalSubjects.orElse(Collections.emptyList()).stream().map(courseMapper::entityToCourseResponse).collect(Collectors.toList());
    }

    protected List<InstitutionResponse> listInstitutionToResponse(List<Institution> institutions) {
        return institutions
                .stream()
                .map(institutionMapper::entityToInstitutionResponse)
                .collect(Collectors.toList());
    }
}
