package br.edu.ifpb.educad.repository;

import br.edu.ifpb.educad.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}