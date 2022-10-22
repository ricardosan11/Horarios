package com.Horarios.Horarios.repository;

import com.Horarios.Horarios.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProfesorRepository extends JpaRepository<Profesor, Long> {
    Optional<Profesor> findByCedula(String cedula);
}
