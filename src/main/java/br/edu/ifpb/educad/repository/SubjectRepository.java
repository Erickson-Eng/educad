package br.edu.ifpb.educad.repository;

import br.edu.ifpb.educad.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}