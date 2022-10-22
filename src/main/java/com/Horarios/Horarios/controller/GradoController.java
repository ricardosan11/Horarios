package com.Horarios.Horarios.controller;


import com.Horarios.Horarios.model.Grado;
import com.Horarios.Horarios.service.GradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grado")
public class GradoController {

    @Autowired
    private GradoService gradoService;

    @PostMapping("/guardarGrado")
    public ResponseEntity<Grado> guardarGrado(@RequestBody Grado grado){
        return ResponseEntity.status(HttpStatus.CREATED).body(gradoService.guardarGrado(grado));
    }

    @GetMapping("/ListarGrados")
    public ResponseEntity<List<Grado>> ListarGrados(){
        return ResponseEntity.ok(gradoService.consultarGrados());
    }

    @GetMapping("/ListarGradoPorAbreviacion/{abreviacion}")
    public ResponseEntity<Optional<Grado>> ListarGradoPorAbreviacion(@PathVariable String abreviacion){
        return ResponseEntity.ok(gradoService.consultarPorAbreviacion(abreviacion));
    }

    @GetMapping("/ListarGradoPorId/{id}")
    public ResponseEntity<Optional<Grado>> ListarGradoPorId(@PathVariable Long id){
        return ResponseEntity.ok(gradoService.consultarPorId(id));
    }

    @DeleteMapping("/eliminarPorId/{id}")
    public void eliminarPorId(@PathVariable Long id){
         gradoService.eliminarGrado(id);
    }

    @PutMapping("/editarGrado")
    public ResponseEntity<Grado> editarGrado(@RequestBody Grado grado){
        return ResponseEntity.status(HttpStatus.OK).body(gradoService.editarrGrado(grado));
    }

}
