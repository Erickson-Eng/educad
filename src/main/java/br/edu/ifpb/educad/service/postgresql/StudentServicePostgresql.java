package br.edu.ifpb.educad.service.postgresql;

import br.edu.ifpb.educad.dto.mapper.StudentMapper;
import br.edu.ifpb.educad.dto.request.StudentRequest;
import br.edu.ifpb.educad.dto.response.StudentResponse;
import br.edu.ifpb.educad.entity.Student;
import br.edu.ifpb.educad.repository.StudentRepository;
import br.edu.ifpb.educad.service.StudentService;
import br.edu.ifpb.educad.service.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServicePostgresql implements StudentService {

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;


    @Override
    public StudentResponse save(StudentRequest studentRequest) {
        Student student = getStudent(studentRequest);
        try{
            studentRepository.save(student);
        }catch (RuntimeException e){
            throw new DataIntegrityViolationException(e.getMessage());
        }
        return getStudentResponse(student);
    }

    @Override
    public StudentResponse update(Long id, StudentRequest studentRequest) {
        Student student = verifyIfExist(id);
        updateData(student, studentRequest);
        studentRepository.save(student);
        return getStudentResponse(student);
    }

    @Override
    public StudentResponse delete(Long id) {
        Student student = verifyIfExist(id);
        studentRepository.delete(student);
        return getStudentResponse(student);
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        Student student = verifyIfExist(id);
        return getStudentResponse(student);
    }

    @Override
    public List<StudentResponse> getStudentByName(String name) {
        List<Student> students = verifyIfExist(name);
        return listStudentToResponse(students);
    }

    protected Student verifyIfExist(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("ID: %s || Não foi encontrado nenhuma entidade para o id fornecido", id)));
    }

    protected List<Student> verifyIfExist(String fullName){
        // return studentRepository.findAllByFullNameContainingIgnoreCase(fullName)
        //         .orElseThrow(() -> new EntityNotFoundException(String.format("Name: %s || Não foi encontrado nenhum estudante para o nome informado", fullName)));

        return null;
    }

    protected void updateData(Student student, StudentRequest request){
        student.setFullName(request.getFullName());
        student.setBirthDate(request.getBirthDate());
        student.setCpf(request.getCpf());
    }

    protected List<StudentResponse> listStudentToResponse(List<Student> students){
        return students
                .stream()
                .map(studentMapper::entityToStudentResponse)
                .collect(Collectors.toList());
    }

    protected Student getStudent(StudentRequest studentRequest){
        return studentMapper.studentRequestToEntity(studentRequest);
    }

    protected StudentResponse getStudentResponse(Student student){
        return studentMapper.entityToStudentResponse(student);
    }
}
