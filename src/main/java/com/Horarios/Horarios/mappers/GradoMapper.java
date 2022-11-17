package com.Horarios.Horarios.mappers;

import com.Horarios.Horarios.model.Grado;
import com.Horarios.Horarios.model.dto.GradoDto;

import java.util.ArrayList;
import java.util.List;

public class GradoMapper {

    public static List<GradoDto> entitysADtos(List<Grado> grados){
        List<GradoDto> gradoDtos = new ArrayList<>();

        for (Grado grado : grados){
            gradoDtos.add(new GradoDto(grado.getId(), grado.getNombre().getNombre(), grado.getAbreviacion(), grado.getNomenclatura().toString(), grado.getNivel().toString(), grado.getCantidadEstudiante()));
        }
        return gradoDtos;
    }

    public static GradoDto entityADto(Grado grado){
        return new GradoDto(grado.getId(), grado.getNombre().getNombre(), grado.getAbreviacion(), grado.getNomenclatura().toString(), grado.getNivel().toString(), grado.getCantidadEstudiante());
    }
}
