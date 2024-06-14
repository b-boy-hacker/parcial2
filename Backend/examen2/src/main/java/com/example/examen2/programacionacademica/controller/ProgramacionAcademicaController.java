package com.example.examen2.programacionacademica.controller;

import com.example.examen2.programacionacademica.model.ProgramacionAcademica;
import com.example.examen2.programacionacademica.service.ProgramacionAcademicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programaciones/")
public class ProgramacionAcademicaController {

    @Autowired
    private ProgramacionAcademicaService programacionAcademicaService;

    @GetMapping
    public List<ProgramacionAcademica> getAllProgramaciones() {
        return programacionAcademicaService.getAllProgramaciones();
    }

    @PostMapping
    public ProgramacionAcademica createProgramacion(@RequestBody ProgramacionAcademica programacionAcademica) {
        return programacionAcademicaService.createProgramacion(programacionAcademica);
    }

    @GetMapping("/{id}")
    public ProgramacionAcademica getProgramacionById(@PathVariable Long id) {
        return programacionAcademicaService.getProgramacionById(id);
    }

    @PutMapping("/{id}")
    public ProgramacionAcademica updateProgramacion(@PathVariable Long id, @RequestBody ProgramacionAcademica programacionDetails) {
        return programacionAcademicaService.updateProgramacion(id, programacionDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProgramacion(@PathVariable Long id) {
        programacionAcademicaService.deleteProgramacion(id);
    }
}
