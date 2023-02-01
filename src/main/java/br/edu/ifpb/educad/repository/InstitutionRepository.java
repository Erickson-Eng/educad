package br.edu.ifpb.educad.repository;

import br.edu.ifpb.educad.entity.Course;
import br.edu.ifpb.educad.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    @Query("SELECT i FROM Institution i WHERE UPPER(i.name) LIKE CONCAT('%', UPPER(:name), '%')")
    Optional<List<Institution>> findInstitutionsByName(String name);

    @Query("SELECT c FROM Course c WHERE c.institution.id = :id")
    Optional<List<Course>> getCoursesByInstitution(Long id);
}