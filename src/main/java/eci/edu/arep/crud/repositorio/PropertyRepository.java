package eci.edu.arep.crud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import eci.edu.arep.crud.modelo.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
