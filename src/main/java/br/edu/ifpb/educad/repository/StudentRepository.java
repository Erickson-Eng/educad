package br.edu.ifpb.educad.repository;

import br.edu.ifpb.educad.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> {

    // Ainda debater a query exata a se fazer
    @Query("SELECT s FROM Student s WHERE UPPER(s.fullName) LIKE CONCAT('%', UPPER(:fullName), '%')")
    Optional<List<Student>> findAllByFullNameContainingIgnoreCase(String fullName);

}