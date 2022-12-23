package com.Horarios.Horarios.controller;

import com.Horarios.Horarios.model.AsignacionProfesor;
import com.Horarios.Horarios.model.dto.AsignacionProfersorDto;
import com.Horarios.Horarios.model.dto.MateriaDto;
import com.Horarios.Horarios.model.dto.ProfesorDto;
import com.Horarios.Horarios.model.dto.ResponseMainDto;
import com.Horarios.Horarios.service.AsignacionProfesorService;
import com.Horarios.Horarios.utils.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = Route.BASE + Route.ASIGNARPROFESOR, produces = MediaType.APPLICATION_JSON_VALUE)
public class AsignacionProfesorController {

    @Autowired
    private AsignacionProfesorService asignacionProfesorService;

    @PostMapping(value = Route.GUARDAR)
    public ResponseEntity<ResponseMainDto> guardarAsignacion(@RequestBody AsignacionProfesor asignacionProfesor){
        Map<String, Object> map = asignacionProfesorService.guardarAsignacion(asignacionProfesor);
        if(map.get("response") != null){
            return new ResponseEntity(new ResponseMainDto("Registro exitoso.", map.get("response")), HttpStatus.CREATED);
        }else {
            return new ResponseEntity(new ResponseMainDto("Registro fallido.", map.get("response")), HttpStatus.BAD_GATEWAY);
        }

    }

    @GetMapping(value = Route.CONSULTAR)
    public ResponseEntity<ResponseMainDto> listarAsignaciones(){
        return new ResponseEntity(new ResponseMainDto("Consultar exitoso.", asignacionProfesorService.consultarAsignaciones()), HttpStatus.FOUND);
    }

    @GetMapping(value = Route.CONSULTARPORMATERIA)
    public ResponseEntity<ResponseMainDto> listarProfesoresPorMateria(@PathVariable Long id){
        List<ProfesorDto> profesorDtoList = asignacionProfesorService.consultarProfesorPorMateria(id);
        if(profesorDtoList != null){
            return new ResponseEntity<>(new ResponseMainDto("Consulta exitosa.", profesorDtoList), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(new ResponseMainDto("Consulta fallida.", profesorDtoList), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = Route.CONSULTARPORPROFESOR)
    public ResponseEntity<ResponseMainDto> listarMateriasPorProfesor(@PathVariable Long id){
        List<MateriaDto> materiaDtoList = asignacionProfesorService.consultarMateriasPorProfesor(id);
        if(materiaDtoList != null){
            return new ResponseEntity<>(new ResponseMainDto("Consulta exitosa.", materiaDtoList), HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(new ResponseMainDto("Consulta fallida.", materiaDtoList), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = Route.CONSULTARPORID)
    public ResponseEntity<ResponseMainDto> listarAsignacionPorId(@PathVariable Long id){
        AsignacionProfersorDto asignacionProfersorDto = asignacionProfesorService.consultarPorId(id);
        if(asignacionProfersorDto != null){
            return new ResponseEntity<>(new ResponseMainDto("Consulta exitosa.", asignacionProfersorDto), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(new ResponseMainDto("Consulta fallida.", asignacionProfersorDto), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = Route.ELIMINAR)
    public ResponseEntity<ResponseMainDto> eliminarAsignacion(@PathVariable Long id){
        Map<String, Object> map = asignacionProfesorService.eliminarAsignacion(id);
        if(map.get("response") != null){
            return new ResponseEntity<>(new ResponseMainDto("Eliminación exitosa.", map.get("response")), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ResponseMainDto("Eliminación fallida.", map.get("response")), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping(value = Route.EDITAR)
    public ResponseEntity<ResponseMainDto> editarAsignacion(@RequestBody AsignacionProfesor asignacionProfesor){
        Map<String, Object> map = asignacionProfesorService.editarAsignacion(asignacionProfesor);
        if(map.get("response") != null){
            return new ResponseEntity<>(new ResponseMainDto("Edición exitosa.", map.get("response")), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ResponseMainDto("Edición fallida.", map.get("response")), HttpStatus.NOT_ACCEPTABLE);
        }
    }
 }
