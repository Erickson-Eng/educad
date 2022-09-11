package br.edu.ifpb.educad.repository;

import br.edu.ifpb.educad.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}