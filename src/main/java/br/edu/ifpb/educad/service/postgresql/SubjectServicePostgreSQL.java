package br.edu.ifpb.educad.service.postgresql;

import br.edu.ifpb.educad.dto.request.SubjectRequest;
import br.edu.ifpb.educad.dto.response.SubjectResponse;
import br.edu.ifpb.educad.repository.SubjectRepository;
import br.edu.ifpb.educad.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SubjectServicePostgreSQL implements SubjectService {
    private SubjectRepository subjectRepository;

    @Override
    public SubjectResponse save(SubjectRequest subjectRequest) {
        return null;
    }

    @Override
    public SubjectResponse update(Long id, SubjectRequest subjectRequest) {
        return null;
    }

    @Override
    public SubjectResponse delete(Long id) {
        return null;
    }

    @Override
    public SubjectResponse getSubjectById(Long id) {
        return null;
    }
}
