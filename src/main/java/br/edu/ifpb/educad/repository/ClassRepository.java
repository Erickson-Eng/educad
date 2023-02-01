package br.edu.ifpb.educad.repository;

import br.edu.ifpb.educad.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class, Long> {
}