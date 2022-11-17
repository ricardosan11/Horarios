package com.Horarios.Horarios.service;

import com.Horarios.Horarios.mappers.DiaMapper;
import com.Horarios.Horarios.model.Dia;
import com.Horarios.Horarios.model.dto.DiaDto;
import com.Horarios.Horarios.repository.IDiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DiaService {

    @Autowired
    private IDiaRepository iDiaRepository;

    public DiaDto consutarPorNombreDia(String nombreDia){
        Optional<Dia> dia = iDiaRepository.findByNombreDia(nombreDia);
        if(dia.isPresent()){
            return DiaMapper.entityADto(dia.get());
        }else {
            return null;
        }
    }

    public boolean consultarPorNombreYFranja(String nombre, String franja){
        Dia dia = iDiaRepository.findByNombreDiaAndFranja(nombre, franja);
        if(dia != null){
            return true;
        }else{
            return false;
        }
    }

    public Map<String, Object> guardarDia(Dia dia){
        Map<String, Object> map = new HashMap<>();
        if(!consultarPorNombreYFranja(dia.getNombreDia().getNombreDia(), dia.getFranja().getFranja().toString())){
            map.put("response", iDiaRepository.save(dia).getId());
        }else{
            map.put("error", null);
        }
        return map;
    }


}
