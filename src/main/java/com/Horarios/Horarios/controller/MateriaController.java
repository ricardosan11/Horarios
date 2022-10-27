package com.Horarios.Horarios.controller;

import com.Horarios.Horarios.model.Materia;
import com.Horarios.Horarios.model.dto.MateriaDto;
import com.Horarios.Horarios.model.dto.ResponseMainDto;
import com.Horarios.Horarios.service.MateriaService;
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
@RequestMapping(value = Route.BASE + Route.MATERIA, produces = MediaType.APPLICATION_JSON_VALUE)
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @PostMapping(value = Route.GUARDAR)
    public ResponseEntity<ResponseMainDto> guardarMateria(@RequestBody Materia materia){
        Map<String, Object> map = materiaService.guardarMateria(materia);
        if(map.get("response") != null){
            return new ResponseEntity<ResponseMainDto>(new ResponseMainDto("Registro exitoso", (Long)map.get("response")), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<ResponseMainDto>(new ResponseMainDto("Registro fallido", (Long)map.get("response")), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = Route.CONSULTAR)
    public ResponseEntity<ResponseMainDto> listarMaterias(){
        return new ResponseEntity<ResponseMainDto>(new ResponseMainDto("Consultar exitoso.", materiaService.consultarMaterias()), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = Route.CONSULTARPORID)
    public ResponseEntity<ResponseMainDto> listarMateriaPorId(@PathVariable Long id){
        MateriaDto materiaDto = materiaService.consultarPorId(id);
        if(materiaDto != null){
            return new ResponseEntity<ResponseMainDto>(new ResponseMainDto("Consultar existoso.", materiaDto), HttpStatus.FOUND);
        }else {
            return new ResponseEntity<ResponseMainDto>(new ResponseMainDto("Consultar fallido.", materiaDto), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = Route.CONSULTARPORNOMBRE)
    public ResponseEntity<ResponseMainDto> listarMateriaPorNombre(@PathVariable String nombre){
        MateriaDto materiaDto = materiaService.consultarPorNombre(nombre);
        if(materiaDto != null){
            return new ResponseEntity<ResponseMainDto>(new ResponseMainDto("Consultar existoso.", materiaDto), HttpStatus.FOUND);
        }else {
            return new ResponseEntity<ResponseMainDto>(new ResponseMainDto("Consultar fallido.", materiaDto), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = Route.ELIMINAR)
    public ResponseEntity<ResponseMainDto> eliminarPorId(@PathVariable Long id){
        Map<String, Object> map = materiaService.eliminarMateria(id);
        if(map.get("response") != null){
            return new ResponseEntity<ResponseMainDto>(new ResponseMainDto("Eliminación exitosa.", map.get("response")), HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<ResponseMainDto>(new ResponseMainDto("Eliminación fallida.", map.get("response")), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = Route.EDITAR)
    public ResponseEntity<ResponseMainDto> editarMateria(@RequestBody Materia materia){
        Map<String, Object> map = materiaService.editarMateria(materia);
        if(map.get("response") != null){
            return new ResponseEntity<ResponseMainDto>(new ResponseMainDto("Modificación exitosa.", map.get("response")), HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<ResponseMainDto>(new ResponseMainDto("Modificación fallida.", map.get("response")), HttpStatus.NOT_MODIFIED);
        }
    }
}
