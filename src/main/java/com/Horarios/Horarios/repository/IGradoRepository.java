package com.Horarios.Horarios.repository;

import com.Horarios.Horarios.model.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGradoRepository extends JpaRepository<Grado, Long> {

    Optional<Grado> findByAbreviacion(String abreviacion);
}
