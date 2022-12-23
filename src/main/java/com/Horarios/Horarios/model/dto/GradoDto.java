package com.Horarios.Horarios.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GradoDto {

    private Long id;
    private String nombre;
    private String abreviacion;
    private String nomenclatura;
    private String nivel;
    private int cantidadEstudiante;

}
