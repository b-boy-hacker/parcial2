package com.example.examen2.carrera.controller;

import com.example.examen2.carrera.model.Facultad;
import com.example.examen2.carrera.service.FacultadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facultades/")
public class FacultadController {

    @Autowired
    private FacultadService facultadService;

    @GetMapping
    public List<Facultad> getAllFacultades() {
        return facultadService.getAllFacultades();
    }

    @PostMapping
    public Facultad createFacultad(@RequestBody Facultad facultad) {
        return facultadService.createFacultad(facultad);
    }

    @GetMapping("/{id}")
    public Facultad getFacultadById(@PathVariable Long id) {
        return facultadService.getFacultadById(id);
    }

    @PutMapping("/{id}")
    public Facultad updateFacultad(@PathVariable Long id, @RequestBody Facultad facultadDetails) {
        return facultadService.updateFacultad(id, facultadDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteFacultad(@PathVariable Long id) {
        facultadService.deleteFacultad(id);
    }
}
