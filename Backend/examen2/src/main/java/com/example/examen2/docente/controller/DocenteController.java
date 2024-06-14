package com.example.examen2.docente.controller;

import com.example.examen2.docente.model.Docente;
import com.example.examen2.docente.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docentes/")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping
    public List<Docente> getAllDocentes() {
        return docenteService.getAllDocentes();
    }

    @PostMapping
    public Docente createDocente(@RequestBody Docente docente) {
        return docenteService.createDocente(docente);
    }

    @GetMapping("/{id}")
    public Docente getDocenteById(@PathVariable Long id) {
        return docenteService.getDocenteById(id);
    }

    @PutMapping("/{id}")
    public Docente updateDocente(@PathVariable Long id, @RequestBody Docente docenteDetails) {
        return docenteService.updateDocente(id, docenteDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteDocente(@PathVariable Long id) {
        docenteService.deleteDocente(id);
    }
}
