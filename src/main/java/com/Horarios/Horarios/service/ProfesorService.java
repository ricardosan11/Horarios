package com.Horarios.Horarios.service;

import com.Horarios.Horarios.mappers.ProfesorMapper;
import com.Horarios.Horarios.model.Profesor;
import com.Horarios.Horarios.model.dto.ProfesorDto;
import com.Horarios.Horarios.model.dto.ResponseMainDto;
import com.Horarios.Horarios.repository.IProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private IProfesorRepository iProfesorRepository;

    private boolean validarProfesor(String cedula){
        if(cedula.equals("")){
            return false;
        }
        if (cedula == null){
            return false;
        }

        return true;
    }

    public Map<String, Object> guardarProfesor(Profesor profesor){
        Map<String, Object> map = new HashMap<>();
        if(consultarPorCedula(profesor.getCedula()) == null && validarProfesor(profesor.getCedula())){
            map.put("response", iProfesorRepository.save(profesor).getId());
        }else{
            map.put("errror", null);
        }
        return map;
    }

    public ProfesorDto consultarPorCedula(String cedula){
        Optional<Profesor> profesor = iProfesorRepository.findByCedula(cedula);
        if(profesor.isPresent()){
             return ProfesorMapper.convertirEntityADto(profesor.get());
        }else {
            return null;
        }

    }

    public ProfesorDto consultarPorId(Long id){

         if(iProfesorRepository.existsById(id)){
             Optional<Profesor> profesor = iProfesorRepository.findById(id);
             return ProfesorMapper.convertirEntityADto(profesor.get());
         }else {
             return null;
         }

    }

    public List<ProfesorDto> consultarProfesores(){
        return ProfesorMapper.convertirEntitysADtos(iProfesorRepository.findAll());
    }

    public Map<String, Object> eliminarProfesor(Long id){
        Map<String, Object> map = new HashMap<>();
        if(iProfesorRepository.existsById(id)){
            map.put("response", id);
            iProfesorRepository.deleteById(id);
        }else{
            map.put("error", null);
        }

        return map;
    }

    public Map<String, Object> editarProfesor(Profesor profesor){
        Map<String, Object> map = new HashMap<>();
        if(profesor.getId() != null && iProfesorRepository.existsById(profesor.getId())){
            map.put("response", iProfesorRepository.save(profesor).getId());
        }else {
            map.put("error", null);
        }

        return map;
    }
}
