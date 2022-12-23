package com.Horarios.Horarios.service;

import com.Horarios.Horarios.mappers.GradoMapper;
import com.Horarios.Horarios.model.Grado;
import com.Horarios.Horarios.model.Nivel;
import com.Horarios.Horarios.model.dto.GradoDto;
import com.Horarios.Horarios.repository.IGradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GradoService {

    @Autowired
    private IGradoRepository iGradoRepository;

    public Map<String, Object> guardarGrado(Grado grado){
        Map<String, Object> map = new HashMap<>();
        if(consultarPorAbreviacion(grado.getAbreviacion()) == null){
            asignacionNivel(grado);
            asignacionAbreviacion(grado);
            map.put("response", iGradoRepository.save(grado).getId());
        }else{
            map.put("error", null);
        }
        return map;
    }

    public List<GradoDto> consultarGrados(){
        List<GradoDto> gradoDtos = GradoMapper.entitysADtos(iGradoRepository.findAll());
        return gradoDtos;
    }

    public Map<String, Object> eliminarGrado(Long id){
        Map<String, Object> map = new HashMap<>();
        if (iGradoRepository.existsById(id)){
            iGradoRepository.deleteById(id);
            map.put("response", id);
            return map;
        }else {
            map.put("response", null);
            return map;
        }
    }

    public Map<String, Object> editarrGrado(Grado grado){
        Map<String, Object> map = new HashMap<>();
        if (grado.getId() != null && iGradoRepository.existsById(grado.getId())){
            asignacionNivel(grado);
            asignacionAbreviacion(grado);
            map.put("response", iGradoRepository.save(grado).getId());
        }else {
            map.put("error", null);
        }
        return map;
    }

    public GradoDto consultarPorAbreviacion(String abreviacion){
        Optional<Grado> grado = iGradoRepository.findByAbreviacion(abreviacion);
        if(grado.isPresent()){
            return GradoMapper.entityADto(grado.get());
        }else{
            return null;
        }
    }

    public GradoDto consultarPorId(Long id){
        Optional<Grado> grado = iGradoRepository.findById(id);
        if(grado.isPresent()){
            return GradoMapper.entityADto(grado.get());
        }
        else{
            return null;
        }
    }

    public void asignacionNivel(Grado grado){
        if(grado.getNombre().ordinal() == 0 || grado.getNombre().ordinal() == 1 || grado.getNombre().ordinal() == 2 || grado.getNombre().ordinal() == 3 || grado.getNombre().ordinal() == 4 ){
              grado.setNivel(Nivel.PRIMARIA);
        }else{
            grado.setNivel(Nivel.BACHILLERATO);
        }
    }

    public void asignacionAbreviacion(Grado grado){
        grado.setAbreviacion(grado.getNombre().getNumeracion() + grado.getNomenclatura());
    }

}
