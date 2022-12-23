package com.Horarios.Horarios.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AsignacionProfersorDto {
    private Long id;
    private ProfesorDto profesorDto;
    private MateriaDto materiaDto;
}
