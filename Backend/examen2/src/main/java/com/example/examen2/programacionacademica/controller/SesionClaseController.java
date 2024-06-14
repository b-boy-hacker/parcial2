package com.example.examen2.programacionacademica.controller;

import com.example.examen2.programacionacademica.model.SesionClase;
import com.example.examen2.programacionacademica.service.SesionClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sesiones/")
public class SesionClaseController {

    @Autowired
    private SesionClaseService sesionClaseService;

    @GetMapping
    public List<SesionClase> getAllSesiones() {
        return sesionClaseService.getAllSesiones();
    }

    @PostMapping
    public SesionClase createSesion(@RequestBody SesionClase sesionClase) {
        return sesionClaseService.createSesion(sesionClase);
    }

    @GetMapping("/{id}")
    public SesionClase getSesionById(@PathVariable Long id) {
        return sesionClaseService.getSesionById(id);
    }

    @PutMapping("/{id}")
    public SesionClase updateSesion(@PathVariable Long id, @RequestBody SesionClase sesionDetails) {
        return sesionClaseService.updateSesion(id, sesionDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteSesion(@PathVariable Long id) {
        sesionClaseService.deleteSesion(id);
    }
}
