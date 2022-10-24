package com.Horarios.Horarios.service;

import com.Horarios.Horarios.model.AsignacionProfesor;
import com.Horarios.Horarios.repository.IAsignacionProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionProfesorServicio {

    @Autowired
    private IAsignacionProfesorRepository iAsignacionProfesorRepository;


    public AsignacionProfesor guardarAsignacion(AsignacionProfesor asignacionProfesor){
        return iAsignacionProfesorRepository.save(asignacionProfesor);
    }

    public List<AsignacionProfesor> consultarAsignaciones(){
        return iAsignacionProfesorRepository.findAll();
    }


}
