package com.Horarios.Horarios.repository;

import com.Horarios.Horarios.model.AsignacionProfesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAsignacionProfesorRepository extends JpaRepository<AsignacionProfesor, Long>{

    @Query(value = "SELECT * FROM asignacion_profesor WHERE materia_id = :id", nativeQuery = true)
    List<AsignacionProfesor> findByMateria(@Param("id") Long id);

    @Query(value = "SELECT * FROM asignacion_profesor WHERE profesor_id = :id", nativeQuery = true)
    List<AsignacionProfesor> findByProfesor(@Param("id") Long id);

    @Query(value = "SELECT * FROM asignacion_profesor WHERE profesor_id = :idProfesor && materia_id = :idMateria", nativeQuery = true)
    AsignacionProfesor findByProfesorAndMateria(@Param("idProfesor") Long idProfesor, @Param("idMateria") Long idMateria);

}
