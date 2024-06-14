package com.example.examen2.asistencia.controller;

import com.example.examen2.asistencia.model.Asistencia;
import com.example.examen2.asistencia.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asistencias/")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping
    public List<Asistencia> getAllAsistencias() {
        return asistenciaService.getAllAsistencias();
    }

    @PostMapping
    public Asistencia createAsistencia(@RequestBody Asistencia asistencia) {
        return asistenciaService.createAsistencia(asistencia);
    }

    @GetMapping("/{id}")
    public Asistencia getAsistenciaById(@PathVariable Long id) {
        return asistenciaService.getAsistenciaById(id);
    }

    @PutMapping("/{id}")
    public Asistencia updateAsistencia(@PathVariable Long id, @RequestBody Asistencia asistenciaDetails) {
        return asistenciaService.updateAsistencia(id, asistenciaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteAsistencia(@PathVariable Long id) {
        asistenciaService.deleteAsistencia(id);
    }
}
