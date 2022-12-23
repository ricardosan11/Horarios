package com.Horarios.Horarios.mappers;

import com.Horarios.Horarios.model.AsignacionProfesor;
import com.Horarios.Horarios.model.Materia;
import com.Horarios.Horarios.model.dto.AsignacionProfersorDto;
import com.Horarios.Horarios.model.dto.ProfesorDto;

import java.util.ArrayList;
import java.util.List;

public class AsignacionProfesorMapper {

    public static List<AsignacionProfersorDto> EntitysADtos(List<AsignacionProfesor> asignacionProfesors){

        List<AsignacionProfersorDto> asignacionProfersorDtos = new ArrayList<>();

        for(AsignacionProfesor asignacionProfesor : asignacionProfesors){
            asignacionProfersorDtos.add(new AsignacionProfersorDto(asignacionProfesor.getId(), ProfesorMapper.convertirEntityADto(asignacionProfesor.getProfesor()), MateriaMapper.convertirEntityADto(asignacionProfesor.getMateria())));
        }
        return asignacionProfersorDtos;
    }

    public static AsignacionProfersorDto EntityADto(AsignacionProfesor asignacionProfesor){
        return new AsignacionProfersorDto(asignacionProfesor.getId(), ProfesorMapper.convertirEntityADto(asignacionProfesor.getProfesor()), MateriaMapper.convertirEntityADto(asignacionProfesor.getMateria()));
    }
}
