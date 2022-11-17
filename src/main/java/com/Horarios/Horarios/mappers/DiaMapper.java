package com.Horarios.Horarios.mappers;

import com.Horarios.Horarios.model.Dia;
import com.Horarios.Horarios.model.dto.DiaDto;

public class DiaMapper {

    public static DiaDto entityADto(Dia dia){
        return new DiaDto(dia.getId(), dia.getNombreDia().getNombreDia(), dia.getFranja().getFranja().toString(), dia.isEstado());
    }
}
