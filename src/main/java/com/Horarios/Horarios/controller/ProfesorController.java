package com.Horarios.Horarios.controller;

import com.Horarios.Horarios.model.Profesor;
import com.Horarios.Horarios.model.dto.ProfesorDto;
import com.Horarios.Horarios.model.dto.ResponseMainDto;
import com.Horarios.Horarios.service.ProfesorService;
import com.Horarios.Horarios.utils.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = Route.BASE + Route.PROFESOR, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping(value = Route.GUARDAR)
    public ResponseEntity<ResponseMainDto> guardarProfesor(@RequestBody Profesor profesor){
        Map<String, Object> map = profesorService.guardarProfesor(profesor);
        if(map.get("response") != null){
            return new ResponseEntity<ResponseMainDto>(new ResponseMainDto("Registro exitoso.", map.get("response")), HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<ResponseMainDto>(new ResponseMainDto("Registro fallido.", map.get("response")), HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @GetMapping(value = Route.CONSULTAR)
    public ResponseEntity<ResponseMainDto> listarProfesores(){
        return new ResponseEntity(new ResponseMainDto("Consultar exitoso.", profesorService.consultarProfesores()), HttpStatus.FOUND);
    }

    @GetMapping(value = Route.CONSULTARPORID)
    public ResponseEntity<ResponseMainDto> listarProfesorPorId(@PathVariable Long id){
        ProfesorDto profesorDto = profesorService.consultarPorId(id);
        if(profesorDto != null){
            return new ResponseEntity<>(new ResponseMainDto("Consulta exitosa.", profesorDto), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(new ResponseMainDto("Consulta fallida.", profesorDto), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = Route.CONSULTARPORCEDULA)
    public ResponseEntity<ResponseMainDto> listarProfesorPorId(@PathVariable String cedula){
        ProfesorDto profesorDto = profesorService.consultarPorCedula(cedula);
        if(profesorDto != null){
            return new ResponseEntity(new ResponseMainDto("Consultar exitoso.", profesorDto), HttpStatus.FOUND);
        }else {
            return new ResponseEntity(new ResponseMainDto("Consultar fallido.", profesorDto), HttpStatus.FOUND);
        }

    }

    @DeleteMapping(value = Route.ELIMINAR)
    public ResponseEntity<ResponseMainDto> eliminarProfesor (@PathVariable Long id){
        Map<String, Object> map = profesorService.eliminarProfesor(id);
        if(map.get("response") != null){
            return new ResponseEntity<>(new ResponseMainDto("Eliminación exitosa.", map.get("response")), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ResponseMainDto("Eliminación fallida.", map.get("response")), HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping(value = Route.EDITAR)
    public ResponseEntity<ResponseMainDto> editarProfesor(@RequestBody Profesor profesor){
        Map<String, Object> map = profesorService.editarProfesor(profesor);
        if(map.get("response") != null){
            return new ResponseEntity(new ResponseMainDto("Modificacion exitosa.", map.get("response")), HttpStatus.OK);
        }else{
            return new ResponseEntity(new ResponseMainDto("Modificacion faliida.", map.get("response")), HttpStatus.NOT_MODIFIED);
        }

    }
}
