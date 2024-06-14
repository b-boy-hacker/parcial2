package com.example.examen2.asistencia.controller;

import com.example.examen2.asistencia.model.Licencia;
import com.example.examen2.asistencia.service.LicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licencias")
public class LicenciaController {

    @Autowired
    private LicenciaService licenciaService;

    @GetMapping
    public List<Licencia> getAllLicencias() {
        return licenciaService.getAllLicencias();
    }

    @PostMapping
    public Licencia createLicencia(@RequestBody Licencia licencia) {
        return licenciaService.createLicencia(licencia);
    }

    @GetMapping("/{id}")
    public Licencia getLicenciaById(@PathVariable Long id) {
        return licenciaService.getLicenciaById(id);
    }

    @PutMapping("/{id}")
    public Licencia updateLicencia(@PathVariable Long id, @RequestBody Licencia licenciaDetails) {
        return licenciaService.updateLicencia(id, licenciaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteLicencia(@PathVariable Long id) {
        licenciaService.deleteLicencia(id);
    }
}
