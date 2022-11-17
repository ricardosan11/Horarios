package com.Horarios.Horarios.service;

import com.Horarios.Horarios.mappers.MateriaMapper;
import com.Horarios.Horarios.model.Materia;
import com.Horarios.Horarios.model.dto.MateriaDto;
import com.Horarios.Horarios.repository.IMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MateriaService {

    @Autowired
    private IMateriaRepository iMateriaRepository;

    public boolean validarObjeto(String nombreMateria){
        if(nombreMateria == null){
            return false;
        }
        if(nombreMateria.equals("")){
            return false;
        }
        return true;
    }

    public Map<String, Object> guardarMateria(Materia materia){
        Map<String, Object> map = new HashMap<String,Object>();
        if(consultarPorNombre(materia.getNombre()) == null && validarObjeto(materia.getNombre())){
            map.put("response", iMateriaRepository.save(materia).getId());
            return map;
        }else{
            map.put("error", null);
            return map;
        }
    }

    public List<MateriaDto> consultarMaterias(){
        return MateriaMapper.convertirEntitysADtos(iMateriaRepository.findAll());
    }

    public Map<String, Object> eliminarMateria(Long id){

        Map<String, Object> map = new HashMap<>();
        if(iMateriaRepository.existsById(id)){
            map.put("response", id);
            iMateriaRepository.deleteById(id);
            return map;
        }else {
            map.put("error", null);
            return map;
        }
    }

    public Map<String, Object> editarMateria(Materia materia){
        Map<String, Object> map = new HashMap<>();
        if(materia.getId() != null && iMateriaRepository.existsById(materia.getId())){
            map.put("response", iMateriaRepository.save(materia).getId());
        }else{
            map.put("error", null);
        }
        return map;
    }

    public MateriaDto consultarPorId(Long id){
        Optional<Materia> optional = iMateriaRepository.findById(id);
        if(optional.isPresent()){
            return MateriaMapper.convertirEntityADto(optional.get());
        }else{
            return null;
        }

    }

    public MateriaDto consultarPorNombre(String nombre){

        Optional<Materia> optional = iMateriaRepository.findByNombre(nombre);
        if (optional.isPresent()){
            return MateriaMapper.convertirEntityADto(optional.get());
        }else{
            return null;
        }

    }
}

