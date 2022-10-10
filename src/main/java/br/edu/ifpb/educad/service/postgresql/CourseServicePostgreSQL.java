package br.edu.ifpb.educad.service.postgresql;

import br.edu.ifpb.educad.dto.mapper.CourseMapper;
import br.edu.ifpb.educad.dto.request.CourseRequest;
import br.edu.ifpb.educad.dto.response.CourseResponse;
import br.edu.ifpb.educad.entity.Course;
import br.edu.ifpb.educad.repository.CourseRepository;
import br.edu.ifpb.educad.service.CourseService;
import br.edu.ifpb.educad.service.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CourseServicePostgreSQL implements CourseService {

    private CourseMapper courseMapper;
    private CourseRepository courseRepository;

    @Override
    public List<CourseResponse> list() {
        List<Course> courses = courseRepository.findAll();
        // Erro ao mapear a entidade para uma resposta
        return courses.stream().map(course -> courseMapper.entityToCourseResponse(course)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public CourseResponse save(CourseRequest courseRequest) {
        try {
            Course course = courseMapper.courseRequestToEntity(courseRequest);
            courseRepository.save(course);
            return courseMapper.entityToCourseResponse(course);
        } catch (RuntimeException e) {
            throw new DataIntegrityViolationException("Unable to save address");
        }
    }

    @Override
    public CourseResponse update(Long id, CourseRequest courseRequest) {
        Course course = verifyIfExist(id);

        updateData(course, courseRequest);

        courseRepository.save(course);

        return courseMapper.entityToCourseResponse(course);
    }

    protected Course verifyIfExist(Long id) {
        return courseRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("ID: %s || Não foi encontrado nenhuma entidade para o id fornecido", id))
        );
    }

    protected void updateData(Course course, CourseRequest courseRequest) {
        course.setName(courseRequest.getName());
    }

}
