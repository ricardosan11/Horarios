package com.Horarios.Horarios.mappers;

import com.Horarios.Horarios.model.Profesor;
import com.Horarios.Horarios.model.dto.ProfesorDto;
import java.util.ArrayList;
import java.util.List;

public class ProfesorMapper {

    public static List<ProfesorDto> convertirEntitysADtos(List<Profesor> profesores){
        List<ProfesorDto> profesorDtos = new ArrayList<>();
        for(Profesor profesor : profesores){
            profesorDtos.add(new ProfesorDto(profesor.getId(), profesor.getNombre(), profesor.getApellido(), profesor.getCedula()));
        }
        return profesorDtos;
    }

    public static ProfesorDto convertirEntityADto(Profesor profesor){
        return new ProfesorDto(profesor.getId(), profesor.getNombre(), profesor.getApellido(), profesor.getCedula());
    }
}
