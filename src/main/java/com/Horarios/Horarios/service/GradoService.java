package com.Horarios.Horarios.service;

import com.Horarios.Horarios.model.Grado;
import com.Horarios.Horarios.repository.IGradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradoService {

    @Autowired
    private IGradoRepository iGradoRepository;

    public Grado guardarGrado(Grado grado){
        Grado grado1 = null;
        if(!consultarPorAbreviacion(grado.getAbreviacion()).isPresent()){
            grado1 = iGradoRepository.save(grado);
        }

        return grado1;
    }

    public List<Grado> consultarGrados(){
        return iGradoRepository.findAll();
    }

    public void eliminarGrado(Long id){
        iGradoRepository.deleteById(id);
    }

    public Grado editarrGrado(Grado grado){
        Grado grado1 = null;
        if (grado.getId() != null && iGradoRepository.existsById(grado.getId())){
            grado1 = iGradoRepository.save(grado);
        }
        return grado1;
    }

    public Optional<Grado> consultarPorAbreviacion(String abreviacion){
        return iGradoRepository.findByAbreviacion(abreviacion);
    }

    public Optional<Grado> consultarPorId(Long id){
        return iGradoRepository.findById(id);
    }

}
