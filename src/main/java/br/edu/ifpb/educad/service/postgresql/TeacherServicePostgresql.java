package br.edu.ifpb.educad.service.postgresql;

import br.edu.ifpb.educad.dto.mapper.SubjectMapper;
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

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherServicePostgresql implements TeacherService {
    private TeacherRepository teacherRepository;

    private TeacherMapper teacherMapper;
    private AddressServicePostgresql addressServicePostgresql;
    private SubjectMapper subjectMapper;

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

        Long addressId = teacher.getAddress().getId();

        updateData(teacher, teacherRequest);
        addressServicePostgresql.update(addressId, teacherRequest.getAddressRequest());

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
        Teacher teacher = verifyIfExists(id);
        return teacherMapper.entityToTeacherResponse(teacher);
    }

    @Override
    public List<TeacherResponse> getTeacherByName(String name) {
        List<Teacher> teachers = verifyIfExists(name);

        return listTeacherToResponse(teachers);
    }

    protected Teacher verifyIfExists(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("ID: %s || Não foi encontrado nenhum professor para o id fornecido", id)));
    }

    protected List<Teacher> verifyIfExists(String fullName) {
        return teacherRepository.findAllByFullNameContainingIgnoreCase(fullName)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Name: %s || Não foi encontrado nenhum professor para o nome informado", fullName)));
    }

    protected void updateData(Teacher teacher, TeacherRequest teacherRequest) {
        teacher.setFullName(teacherRequest.getFullName());
        teacher.setBirthDate(teacherRequest.getBirthDate());
        teacher.setCpf(teacherRequest.getCpf());
    }

    protected List<TeacherResponse> listTeacherToResponse(List<Teacher> teachers) {
        return teachers.stream().map(teacherMapper::entityToTeacherResponse).collect(Collectors.toList());
    }
}
