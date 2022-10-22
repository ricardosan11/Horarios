package com.Horarios.Horarios.controller;

import com.Horarios.Horarios.model.Profesor;
import com.Horarios.Horarios.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping("/guardarProfesor")
    public ResponseEntity<Profesor> guardarProfesor(@RequestBody Profesor profesor){
        return ResponseEntity.status(HttpStatus.CREATED).body(profesorService.guardarProfesor(profesor));
    }

    @GetMapping("/consultarProfesores")
    public ResponseEntity<List<Profesor>> listarProfesores(){
        return ResponseEntity.ok(profesorService.consultarProfesores());
    }

    @GetMapping("/consultarProfesorPorId/{id}")
    public ResponseEntity<Optional<Profesor>> listarProfesorPorId(@PathVariable Long id){
        return ResponseEntity.ok(profesorService.consultarPorId(id));
    }

    @GetMapping("/consultarProfesorPorCedula/{cedula}")
    public ResponseEntity<Optional<Profesor>> listarProfesorPorId(@PathVariable String cedula){
        return ResponseEntity.ok(profesorService.consultarPorCedula(cedula));
    }

    @DeleteMapping("/eliminarPorId/{id}")
    public void eliminarPorId(@PathVariable Long id){
        profesorService.eliminarProfesor(id);
    }

    @PutMapping("/editarProfesor")
    public ResponseEntity<Profesor> editarProfesor(@RequestBody Profesor profesor){
        return ResponseEntity.status(HttpStatus.FOUND).body(profesorService.editarProfesor(profesor));
    }
}
