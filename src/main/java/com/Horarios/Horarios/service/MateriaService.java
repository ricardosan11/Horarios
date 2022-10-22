package com.Horarios.Horarios.service;

import com.Horarios.Horarios.model.Materia;
import com.Horarios.Horarios.repository.IMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private IMateriaRepository iMateriaRepository;

    public Materia guardarMateria(Materia materia){
        Materia validacionMateria = null;
        if(!consultarPorNombre(materia.getNombre()).isPresent()){
            validacionMateria = iMateriaRepository.save(materia);
        }
        return validacionMateria;
    }

    public List<Materia> consultarMaterias(){
        return iMateriaRepository.findAll();
    }

    public void eliminarMateria(Long id){

        iMateriaRepository.deleteById(id);
    }

    public Materia editarMateria(Materia materia){
        Materia validacionMateria = null;
        if(materia.getId() != null && iMateriaRepository.existsById(materia.getId())){
            validacionMateria = iMateriaRepository.save(materia);
        }
        return validacionMateria;
    }

    public Optional<Materia> consultarPorId(Long id){
        return iMateriaRepository.findById(id);
    }

    public Optional<Materia> consultarPorNombre(String nombre){
        return iMateriaRepository.findByNombre(nombre);
    }
}

