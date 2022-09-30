package br.edu.ifpb.educad.service.postgresql;

import br.edu.ifpb.educad.dto.mapper.TeacherMapper;
import br.edu.ifpb.educad.dto.request.TeacherRequest;
import br.edu.ifpb.educad.dto.response.TeacherResponse;
import br.edu.ifpb.educad.entity.Teacher;
import br.edu.ifpb.educad.repository.TeacherRepository;
import br.edu.ifpb.educad.service.TeacherService;
import br.edu.ifpb.educad.service.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherServicePostgresql implements TeacherService {
    private TeacherRepository teacherRepository;

    private TeacherMapper teacherMapper;

    @Override
    public List<TeacherResponse> list() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(teacher -> teacherMapper.entityToTeacherResponse(teacher)).collect(Collectors.toList());
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
        Teacher teacher = verifyIfExists(id);
        updateData(teacher, teacherRequest);
        teacherRepository.save(teacher);
        return teacherMapper.entityToTeacherResponse(teacher);
    }

    @Override
    public TeacherResponse delete(Long id) {
        Teacher teacher = verifyIfExists(id);
        teacherRepository.delete(teacher);
        return teacherMapper.entityToTeacherResponse(teacher);
    }

    @Override
    public TeacherResponse getTeacherById(Long id) {
        return null;
    }

    protected Teacher verifyIfExists(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("ID: %s || Não foi encontrado nenhuma entidade para o id fornecido", id)));
    }

    protected void updateData(Teacher teacher, TeacherRequest teacherRequest) {
        teacher.setFullName(teacherRequest.getFullName());
        teacher.setBirthDate(teacherRequest.getBirthDate());
        teacher.setCpf(teacherRequest.getCpf());
    }
}
