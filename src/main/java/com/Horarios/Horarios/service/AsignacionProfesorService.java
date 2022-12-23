package com.Horarios.Horarios.service;

import com.Horarios.Horarios.mappers.AsignacionProfesorMapper;
import com.Horarios.Horarios.mappers.MateriaMapper;
import com.Horarios.Horarios.mappers.ProfesorMapper;
import com.Horarios.Horarios.model.AsignacionProfesor;
import com.Horarios.Horarios.model.dto.AsignacionProfersorDto;
import com.Horarios.Horarios.model.dto.MateriaDto;
import com.Horarios.Horarios.model.dto.ProfesorDto;
import com.Horarios.Horarios.repository.IAsignacionProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AsignacionProfesorService {

    @Autowired
    private IAsignacionProfesorRepository iAsignacionProfesorRepository;
    @Autowired
    private MateriaService materiaService;
    @Autowired
    private ProfesorService profesorService;


    public Map<String, Object> guardarAsignacion(AsignacionProfesor asignacionProfesor){
        Map<String, Object> map = new HashMap<>();
        if(validacionAsignacion(asignacionProfesor)){
            map.put("response", iAsignacionProfesorRepository.save(asignacionProfesor).getId());
        }else {
            map.put("error", null);
        }
        return map;
    }

    public List<AsignacionProfersorDto> consultarAsignaciones(){
        return AsignacionProfesorMapper.EntitysADtos(iAsignacionProfesorRepository.findAll());
    }

    public List<ProfesorDto> consultarProfesorPorMateria(Long id){
        List<ProfesorDto> profesorDtoList = new ArrayList<>();
        List<AsignacionProfesor> profesorList = iAsignacionProfesorRepository.findByMateria(id);
        for (AsignacionProfesor profesor : profesorList){
            profesorDtoList.add(ProfesorMapper.convertirEntityADto(profesor.getProfesor()));
        }
        return profesorDtoList;
    }

    public List<MateriaDto> consultarMateriasPorProfesor(Long id){
        List<MateriaDto> materiaDtoList = new ArrayList<>();
        List<AsignacionProfesor> materiaList = iAsignacionProfesorRepository.findByProfesor(id);
        for (AsignacionProfesor materia : materiaList){
            materiaDtoList.add(MateriaMapper.convertirEntityADto(materia.getMateria()));
        }
        return materiaDtoList;
    }

    public Map<String, Object> eliminarAsignacion(Long id){
        Map<String, Object> map = new HashMap<>();

        if (iAsignacionProfesorRepository.existsById(id)){
            iAsignacionProfesorRepository.deleteById(id);
            map.put("response", id);
        }else{
            map.put("error", null);
        }
        return map;
    }

    public boolean validacionAsignacion(AsignacionProfesor asignacionProfesor){


        AsignacionProfesor validacion = iAsignacionProfesorRepository.findByProfesorAndMateria(asignacionProfesor.getProfesor().getId(), asignacionProfesor.getMateria().getId());
        if (validacion != null){
            return false;
        }
        if(materiaService.consultarPorId(asignacionProfesor.getMateria().getId()) == null){
            return false;
        }
        if(profesorService.consultarPorId(asignacionProfesor.getProfesor().getId()) == null){
            return false;
        }
            return true;
    }

    public AsignacionProfersorDto consultarPorId(Long id){
        Optional<AsignacionProfesor> optional = iAsignacionProfesorRepository.findById(id);
        if(optional.isPresent()){
            return AsignacionProfesorMapper.EntityADto(optional.get());
        }else {
            return null;
        }
    }

    public Map<String, Object> editarAsignacion(AsignacionProfesor asignacionProfesor){
        Map<String, Object> map = new HashMap<>();

        Optional<AsignacionProfesor> profesorAEditar = iAsignacionProfesorRepository.findById(asignacionProfesor.getId());
        if(validacionEdicionAsignacion(asignacionProfesor.getProfesor().getId(), asignacionProfesor.getMateria().getId()) && (profesorAEditar.get().getProfesor().getId() != asignacionProfesor.getProfesor().getId() || profesorAEditar.get().getMateria().getId() != asignacionProfesor.getMateria().getId())){
            map.put("response", iAsignacionProfesorRepository.save(asignacionProfesor).getId());
        }else {
            map.put("error", null);
        }
        return map;
    }

    public boolean validacionEdicionAsignacion(Long idProfesor, Long idMateria){
        AsignacionProfesor validacion = iAsignacionProfesorRepository.findByProfesorAndMateria(idProfesor, idMateria);
        if(validacion == null){
            return false;
        }else {
            return true;
        }
    }

}
