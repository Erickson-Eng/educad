package br.edu.ifpb.educad.repository;

import br.edu.ifpb.educad.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> {

    // @Query("select s from Student s where upper(s.fullName) = concat('%', upper(:fullname), '%' ) ")
    // Optional<List<Student>> findAllByFullNameContainingIgnoreCase(String fullName);
}