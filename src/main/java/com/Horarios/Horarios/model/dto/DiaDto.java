package com.Horarios.Horarios.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DiaDto {

    private Long id;
    private String nombreDía;
    private String franja;
    private boolean estado;
}
