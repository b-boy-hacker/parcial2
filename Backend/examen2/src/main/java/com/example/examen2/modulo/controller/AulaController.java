package com.example.examen2.modulo.controller;

import com.example.examen2.modulo.model.Aula;
import com.example.examen2.modulo.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aulas/")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @GetMapping
    public List<Aula> getAllAulas() {
        return aulaService.getAllAulas();
    }

    @PostMapping
    public Aula createAula(@RequestBody Aula aula) {
        return aulaService.createAula(aula);
    }

    @GetMapping("/{id}")
    public Aula getAulaById(@PathVariable Long id) {
        return aulaService.getAulaById(id);
    }

    @PutMapping("/{id}")
    public Aula updateAula(@PathVariable Long id, @RequestBody Aula aulaDetails) {
        return aulaService.updateAula(id, aulaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteAula(@PathVariable Long id) {
        aulaService.deleteAula(id);
    }
}
