package br.edu.ifpb.educad.repository;

import br.edu.ifpb.educad.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}