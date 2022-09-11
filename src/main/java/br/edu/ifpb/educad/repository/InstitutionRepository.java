package br.edu.ifpb.educad.repository;

import br.edu.ifpb.educad.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}