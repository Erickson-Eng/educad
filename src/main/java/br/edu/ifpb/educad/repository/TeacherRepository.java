package br.edu.ifpb.educad.repository;

import br.edu.ifpb.educad.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE UPPER(t.fullName) LIKE CONCAT('%', UPPER(:fullName), '%')")
    Optional<List<Teacher>> findAllByFullNameContainingIgnoreCase(String fullName);

//    @Query("SELECT s FROM Subject s WHERE s.teacher.id = :id")
//    Optional<List<String>> getSubjectByTeacher(Long id);
}