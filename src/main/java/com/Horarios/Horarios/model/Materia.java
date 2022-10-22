package com.Horarios.Horarios.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
}
