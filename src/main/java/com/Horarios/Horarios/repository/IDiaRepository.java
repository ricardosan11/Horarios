package com.Horarios.Horarios.repository;

import com.Horarios.Horarios.model.Dia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDiaRepository extends JpaRepository<Dia, Long> {

    Optional<Dia> findByNombreDia(String nombreDia);

    @Query("SELECT * FROM dias WHERE nombre_dia = :nombre && franja = :franja")
    Dia findByNombreDiaAndFranja(@Param("nombre") String nombre, @Param("franja") String franja);
}
