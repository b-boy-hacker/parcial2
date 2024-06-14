package com.example.examen2.reporte.controller;

import com.example.examen2.reporte.model.TipoReporte;
import com.example.examen2.reporte.service.TipoReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-reporte")
public class TipoReporteController {

    @Autowired
    private TipoReporteService tipoReporteService;

    @GetMapping
    public List<TipoReporte> getAllTiposReporte() {
        return tipoReporteService.getAllTiposReporte();
    }

    @PostMapping
    public TipoReporte createTipoReporte(@RequestBody TipoReporte tipoReporte) {
        return tipoReporteService.createTipoReporte(tipoReporte);
    }

    @GetMapping("/{id}")
    public TipoReporte getTipoReporteById(@PathVariable Long id) {
        return tipoReporteService.getTipoReporteById(id);
    }

    @PutMapping("/{id}")
    public TipoReporte updateTipoReporte(@PathVariable Long id, @RequestBody TipoReporte tipoReporteDetails) {
        return tipoReporteService.updateTipoReporte(id, tipoReporteDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTipoReporte(@PathVariable Long id) {
        tipoReporteService.deleteTipoReporte(id);
    }
}
