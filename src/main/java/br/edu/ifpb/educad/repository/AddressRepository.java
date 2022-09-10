package br.edu.ifpb.educad.repository;

import br.edu.ifpb.educad.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}