package com.Horarios.Horarios.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String cedula;

}
