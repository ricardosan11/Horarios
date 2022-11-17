package com.Horarios.Horarios.mappers;

import com.Horarios.Horarios.model.Materia;
import com.Horarios.Horarios.model.dto.MateriaDto;

import java.util.ArrayList;
import java.util.List;

public class MateriaMapper {


    public static List<MateriaDto> convertirEntitysADtos(List<Materia> materias){
            List<MateriaDto> materiasDto = new ArrayList<>();
            for(Materia materia : materias){
                materiasDto.add(new MateriaDto(materia.getId(), materia.getNombre(), materia.getDescripcion()));
            }
            return materiasDto;
    }

    public static MateriaDto convertirEntityADto(Materia materia){
        return new MateriaDto(materia.getId(), materia.getNombre(), materia.getDescripcion());
    }
}
