package com.Horarios.Horarios.controller;


import com.Horarios.Horarios.model.Grado;
import com.Horarios.Horarios.model.dto.GradoDto;
import com.Horarios.Horarios.model.dto.ResponseMainDto;
import com.Horarios.Horarios.service.GradoService;
import com.Horarios.Horarios.utils.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = Route.BASE + Route.GRADO, produces = MediaType.APPLICATION_JSON_VALUE)
public class GradoController {

    @Autowired
    private GradoService gradoService;

    @PostMapping(value = Route.GUARDAR)
    public ResponseEntity<ResponseMainDto> guardarGrado(@RequestBody Grado grado){
        Map<String, Object> map = gradoService.guardarGrado(grado);
        if(map.get("response") != null){
            return new ResponseEntity<>(new ResponseMainDto("Registro exitoso.", map.get("response")), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(new ResponseMainDto("Registro fallido.", null), HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @GetMapping(value = Route.CONSULTAR)
    public ResponseEntity<ResponseMainDto> ListarGrados(){
        return new ResponseEntity(new ResponseMainDto("Consulta exitosa. ", gradoService.consultarGrados()), HttpStatus.OK);
    }

    @GetMapping(value = Route.CONSULTARPORABREVIACION)
    public ResponseEntity<ResponseMainDto> ListarGradoPorAbreviacion(@PathVariable String abreviacion){
        GradoDto gradoDto = gradoService.consultarPorAbreviacion(abreviacion);
        if(gradoDto != null){
            return new ResponseEntity(new ResponseMainDto("Consultar exitoso.", gradoDto), HttpStatus.FOUND);
        }else{
            return new ResponseEntity(new ResponseMainDto("Consultar fallido.", gradoDto), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = Route.CONSULTARPORID)
    public ResponseEntity<ResponseMainDto> ListarGradoPorId(@PathVariable Long id){
        GradoDto gradoDto = gradoService.consultarPorId(id);
        if(gradoDto != null){
            return new ResponseEntity(new ResponseMainDto("Consultar exitoso.", gradoDto), HttpStatus.FOUND);
        }else {
            return new ResponseEntity(new ResponseMainDto("Consultar fallido.", gradoDto), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = Route.ELIMINAR)
    public ResponseEntity<ResponseMainDto> eliminarPorId(@PathVariable Long id){
        Map<String, Object> map = gradoService.eliminarGrado(id);
        if(map.get("response") != null){
            return new ResponseEntity<>(new ResponseMainDto("Eliminar exitoso.", map.get("response")), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ResponseMainDto("Eliminar fallido.", map.get("response")), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = Route.EDITAR)
    public ResponseEntity<ResponseMainDto> editarGrado(@RequestBody Grado grado){
        Map<String, Object> map = gradoService.editarrGrado(grado);
        if(map.get("response") != null){
            return new ResponseEntity<>(new ResponseMainDto("Edición exitosa.", map.get("response")), HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(new ResponseMainDto("Edición fallida.", map.get("response")), HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
