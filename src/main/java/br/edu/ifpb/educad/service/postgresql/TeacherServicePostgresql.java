package br.edu.ifpb.educad.service.postgresql;

import br.edu.ifpb.educad.dto.mapper.TeacherMapper;
import br.edu.ifpb.educad.dto.request.TeacherRequest;
import br.edu.ifpb.educad.dto.response.TeacherResponse;
import br.edu.ifpb.educad.entity.Teacher;
import br.edu.ifpb.educad.repository.TeacherRepository;
import br.edu.ifpb.educad.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherServicePostgresql implements TeacherService {
    private TeacherRepository teacherRepository;
    private TeacherMapper teacherMapper;

    @Override
    public List<TeacherResponse> list() {
        return null;
    }

    @Override
    public TeacherResponse save(TeacherRequest teacherRequest) {
        Teacher teacher = teacherMapper.teacherRequestToEntity(teacherRequest);
        try {
            teacherRepository.save(teacher);
        } catch (RuntimeException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
        return teacherMapper.entityToTeacherResponse(teacher);
    }

    @Override
    public TeacherResponse update(Long id, TeacherRequest teacherRequest) {
        return null;
    }

    @Override
    public TeacherResponse delete(Long id) {
        return null;
    }

    @Override
    public TeacherResponse getTeacherById(Long id) {
        return null;
    }

    // getTeacherByName
}
