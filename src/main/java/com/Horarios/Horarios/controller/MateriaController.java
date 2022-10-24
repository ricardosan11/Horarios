package com.Horarios.Horarios.controller;

import com.Horarios.Horarios.model.Materia;
import com.Horarios.Horarios.model.dto.ResponseMainDto;
import com.Horarios.Horarios.service.MateriaService;
import com.Horarios.Horarios.utils.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @GetMapping("/consultarMaterias")
    public ResponseEntity<List<Materia>> listarMaterias(){
        return ResponseEntity.ok(materiaService.consultarMaterias());
    }

    @GetMapping("/consultarMateriaPorId/{id}")
    public ResponseEntity<Optional<Materia>> listarMateriaPorId(@PathVariable Long id){
        return ResponseEntity.ok(materiaService.consultarPorId(id));
    }

    @GetMapping("/consultarMateriaPorNombre/{nombre}")
    public ResponseEntity<Optional<Materia>> listarMateriaPorNombre(@PathVariable String nombre){
        return ResponseEntity.ok(materiaService.consultarPorNombre(nombre));
    }

    @DeleteMapping("/eliminarPorId/{id}")
    public void eliminarPorId(@PathVariable Long id){
        materiaService.eliminarMateria(id);
    }

    @PutMapping("/editarMateria")
    public ResponseEntity<Materia> editarMateria(@RequestBody Materia materia){
        return ResponseEntity.status(HttpStatus.FOUND).body(materiaService.editarMateria(materia));
    }
}
