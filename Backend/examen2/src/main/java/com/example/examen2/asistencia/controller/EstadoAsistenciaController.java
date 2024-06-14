package com.example.examen2.asistencia.controller;

import com.example.examen2.asistencia.model.EstadoAsistencia;
import com.example.examen2.asistencia.service.EstadoAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadosasistencia")
public class EstadoAsistenciaController {

    @Autowired
    private EstadoAsistenciaService estadoAsistenciaService;

    @GetMapping
    public List<EstadoAsistencia> getAllEstadosAsistencia() {
        return estadoAsistenciaService.getAllEstadosAsistencia();
    }

    @PostMapping
    public EstadoAsistencia createEstadoAsistencia(@RequestBody EstadoAsistencia estadoAsistencia) {
        return estadoAsistenciaService.createEstadoAsistencia(estadoAsistencia);
    }

    @GetMapping("/{id}")
    public EstadoAsistencia getEstadoAsistenciaById(@PathVariable Long id) {
        return estadoAsistenciaService.getEstadoAsistenciaById(id);
    }

    @PutMapping("/{id}")
    public EstadoAsistencia updateEstadoAsistencia(@PathVariable Long id, @RequestBody EstadoAsistencia estadoAsistenciaDetails) {
        return estadoAsistenciaService.updateEstadoAsistencia(id, estadoAsistenciaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEstadoAsistencia(@PathVariable Long id) {
        estadoAsistenciaService.deleteEstadoAsistencia(id);
    }
}
