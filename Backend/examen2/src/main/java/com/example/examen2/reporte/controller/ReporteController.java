package com.example.examen2.reporte.controller;

import com.example.examen2.reporte.model.Reporte;
import com.example.examen2.reporte.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public List<Reporte> getAllReportes() {
        return reporteService.getAllReportes();
    }

    @PostMapping
    public Reporte createReporte(@RequestBody Reporte reporte) {
        return reporteService.createReporte(reporte);
    }

    @GetMapping("/{id}")
    public Reporte getReporteById(@PathVariable Long id) {
        return reporteService.getReporteById(id);
    }

    @PutMapping("/{id}")
    public Reporte updateReporte(@PathVariable Long id, @RequestBody Reporte reporteDetails) {
        return reporteService.updateReporte(id, reporteDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteReporte(@PathVariable Long id) {
        reporteService.deleteReporte(id);
    }
}
