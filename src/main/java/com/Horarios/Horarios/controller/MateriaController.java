package com.Horarios.Horarios.controller;

import com.Horarios.Horarios.model.Materia;
import com.Horarios.Horarios.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @PostMapping("/guardarMateria")
    public ResponseEntity<Materia> guardarMateria(@RequestBody Materia materia){
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaService.guardarMateria(materia));
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
