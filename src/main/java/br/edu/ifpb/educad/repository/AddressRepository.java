package br.edu.ifpb.educad.repository;

import br.edu.ifpb.educad.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}