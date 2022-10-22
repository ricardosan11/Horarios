package com.Horarios.Horarios.service;

import com.Horarios.Horarios.model.Profesor;
import com.Horarios.Horarios.repository.IProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private IProfesorRepository iProfesorRepository;

    public Profesor guardarProfesor(Profesor profesor){
        Profesor validarProfesor = null;
        if(!consultarPorCedula(profesor.getCedula()).isPresent()){
            validarProfesor = iProfesorRepository.save(profesor);
        }
        return validarProfesor;
    }

    public Optional<Profesor> consultarPorCedula(String cedula){
        return iProfesorRepository.findByCedula(cedula);
    }

    public Optional<Profesor> consultarPorId(Long id){
        return iProfesorRepository.findById(id);
    }

    public List<Profesor> consultarProfesores(){
        return iProfesorRepository.findAll();
    }

    public void eliminarProfesor(Long id){
        iProfesorRepository.deleteById(id);
    }

    public Profesor editarProfesor(Profesor profesor){
        Profesor validarProfesor = null;

        if(profesor.getId() != null && iProfesorRepository.existsById(profesor.getId())){
            validarProfesor = iProfesorRepository.save(profesor);
        }

        return validarProfesor;
    }
}
