package com.Horarios.Horarios.repository;

import com.Horarios.Horarios.model.AsignacionProfesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAsignacionProfesorRepository extends JpaRepository<AsignacionProfesor, Long>{



}
