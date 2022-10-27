package com.Horarios.Horarios.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Grado")
public class Grado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String codigo;
    private String nombre;
    private String abreviacion;
    private Nomenclatura nomenclatura;
    private Nivel nivel;
    @Column(name = "cantidad_estudiante")
    private int cantidadEstiante;

}



