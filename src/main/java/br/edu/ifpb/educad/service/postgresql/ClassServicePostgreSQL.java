package br.edu.ifpb.educad.service.postgresql;

import br.edu.ifpb.educad.dto.mapper.ClassMapper;
import br.edu.ifpb.educad.dto.request.ClassRequest;
import br.edu.ifpb.educad.dto.response.ClassResponse;
import br.edu.ifpb.educad.entity.Class;
import br.edu.ifpb.educad.repository.ClassRepository;
import br.edu.ifpb.educad.service.ClassService;
import br.edu.ifpb.educad.service.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClassServicePostgreSQL implements ClassService {

    private ClassRepository classRepository;
    private ClassMapper classMapper;
    private TeacherServicePostgresql teacherServicePostgresql;

    @Override
    public ClassResponse save(ClassRequest classRequest) {
        Class aClass = classMapper.classRequestToEntity(classRequest);

        try {
            classRepository.save(aClass);
        } catch (RuntimeException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }

        return classMapper.entityToClassResponse(aClass);
    }

    @Override
    public ClassResponse update(Long id, ClassRequest classRequest) {
        Class aClass = verifyIfExists(id);

        updateData(aClass, classRequest);

        classRepository.save(aClass);

        return classMapper.entityToClassResponse(aClass);
    }

    @Override
    public ClassResponse delete(Long id) {
        Class aClass = verifyIfExists(id);

        classRepository.delete(aClass);

        return classMapper.entityToClassResponse(aClass);
    }

    @Override
    public ClassResponse getClassById(Long id) {
        Class aClass = verifyIfExists(id);

        return classMapper.entityToClassResponse(aClass);
    }

    protected Class verifyIfExists(Long id) {
        return classRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("ID: %s || Não foi encontrado nenhuma entidade para o id fornecido", id))
        );
    }

    protected void updateData(Class aClass, ClassRequest classRequest) {
//        aClass.setName(classRequest.getName());
//        aClass.setPeriod(classRequest.getPeriod());
//        aClass.setSubject(
//                subjectServicePostgreSQL.verifyIfExists(
//                        classRequest.getSubjectId()
//                )
//        );
//        aClass.setTeacher(
//                teacherServicePostgresql.verifyIfExists(
//                        classRequest.getTeacherId()
//                )
//        );
    }
}
