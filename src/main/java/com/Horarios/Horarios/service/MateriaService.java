package com.Horarios.Horarios.service;

import com.Horarios.Horarios.model.Materia;
import com.Horarios.Horarios.repository.IMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private IMateriaRepository iMateriaRepository;

    public Map<String, Object> guardarMateria(Materia materia){
        Map<String, Object> map = new HashMap<String,Object>();
        if(!consultarPorNombre(materia.getNombre()).isPresent() && validarObjeto(materia.getNombre())){
            map.put("response", iMateriaRepository.save(materia).getId());
            return map;
        }else{
            return map;
        }
    }

    public boolean validarObjeto(String nombreMateria){
        if(nombreMateria == null){
            return false;
        }
        if(nombreMateria.equals("")){
            return false;
        }
        return true;
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

