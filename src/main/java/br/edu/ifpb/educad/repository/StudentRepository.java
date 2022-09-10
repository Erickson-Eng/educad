package br.edu.ifpb.educad.repository;

import br.edu.ifpb.educad.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}