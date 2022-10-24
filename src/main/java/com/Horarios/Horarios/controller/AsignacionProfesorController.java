package com.Horarios.Horarios.controller;

import com.Horarios.Horarios.model.AsignacionProfesor;
import com.Horarios.Horarios.service.AsignacionProfesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignacionProfesor")
public class AsignacionProfesorController {

    @Autowired
    private AsignacionProfesorServicio asignacionProfesorServicio;

    @PostMapping("/guardarAsignacion")
    public ResponseEntity<AsignacionProfesor> guardarAsignacion(@RequestBody AsignacionProfesor asignacionProfesor){
        return ResponseEntity.status(HttpStatus.CREATED).body(asignacionProfesorServicio.guardarAsignacion(asignacionProfesor));
    }

    @GetMapping("/listarAsignaciones")
    public ResponseEntity<List<AsignacionProfesor>> listarAsignaciones(){
        return ResponseEntity.ok(asignacionProfesorServicio.consultarAsignaciones());
    }
}
