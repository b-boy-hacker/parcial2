package com.example.examen2.materia.controller;

import com.example.examen2.materia.model.MateriaDTO;
import com.example.examen2.materia.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias/")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public List<MateriaDTO> getAllMaterias() {
        return materiaService.getAllMaterias();
    }

    @PostMapping
    public MateriaDTO createMateria(@RequestBody MateriaDTO materiaDTO) {
        return materiaService.createMateria(materiaDTO);
    }

    @GetMapping("/{id}")
    public MateriaDTO getMateriaById(@PathVariable Long id) {
        return materiaService.getMateriaById(id);
    }

    @PutMapping("/{id}")
    public MateriaDTO updateMateria(@PathVariable Long id, @RequestBody MateriaDTO materiaDTO) {
        return materiaService.updateMateria(id, materiaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMateria(@PathVariable Long id) {
        materiaService.deleteMateria(id);
    }
}
