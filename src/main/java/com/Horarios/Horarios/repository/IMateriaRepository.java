package com.Horarios.Horarios.repository;

import com.Horarios.Horarios.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMateriaRepository extends JpaRepository<Materia, Long> {
    Optional<Materia> findByNombre(String nombre);
}
