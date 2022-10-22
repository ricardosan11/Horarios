package com.Horarios.Horarios.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Grado")
public class Grado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private String abreviacion;
    private Nomenclatura nomenclatura;
    private Nivel nivel;

}



