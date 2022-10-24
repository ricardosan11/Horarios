package com.Horarios.Horarios.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "AsignacionProfesor")
public class AsignacionProfesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "profesor_id", referencedColumnName = "id")
    private Profesor profesor;
    @ManyToOne
    @JoinColumn(name = "materia_id", referencedColumnName = "id")
    private Materia materia;
}
