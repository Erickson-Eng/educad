package br.edu.ifpb.educad.service.postgresql;

import br.edu.ifpb.educad.dto.mapper.SubjectMapper;
import br.edu.ifpb.educad.dto.request.SubjectRequest;
import br.edu.ifpb.educad.dto.response.SubjectResponse;
import br.edu.ifpb.educad.entity.Subject;
import br.edu.ifpb.educad.repository.SubjectRepository;
import br.edu.ifpb.educad.service.SubjectService;
import br.edu.ifpb.educad.service.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SubjectServicePostgreSQL implements SubjectService {
    private SubjectRepository subjectRepository;
    private SubjectMapper subjectMapper;

    @Override
    public SubjectResponse save(SubjectRequest subjectRequest) {
        Subject subject = subjectMapper.subjectRequestToEntity(subjectRequest);

        try {
            subjectRepository.save(subject);
        } catch (RuntimeException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }

        return subjectMapper.entityToSubjectResponse(subject);
    }

    @Override
    public SubjectResponse update(Long id, SubjectRequest subjectRequest) {
        Subject subject = verifyIfExists(id);

        updateData(subject, subjectRequest);

        subjectRepository.save(subject);

        return subjectMapper.entityToSubjectResponse(subject);
    }

    @Override
    public SubjectResponse delete(Long id) {
        Subject subject = verifyIfExists(id);

        subjectRepository.delete(subject);

        return subjectMapper.entityToSubjectResponse(subject);
    }

    @Override
    public SubjectResponse getSubjectById(Long id) {
        Subject subject = verifyIfExists(id);

        return subjectMapper.entityToSubjectResponse(subject);
    }

    protected Subject verifyIfExists(Long id) {
        return subjectRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("ID: %s || Não foi encontrado nenhuma entidade para o id fornecido", id))
        );
    }

    protected void updateData(Subject subject, SubjectRequest subjectRequest) {
        subject.setName(subjectRequest.getName());
        subject.setPeriod(subjectRequest.getPeriod());
        subject.setRegistration(subjectRequest.getRegistration());
    }
}
