package com.example.examen2.reporte.service;

import com.example.examen2.reporte.model.TipoReporte;
import com.example.examen2.reporte.repository.TipoReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoReporteService {

    @Autowired
    private TipoReporteRepository tipoReporteRepository;

    public List<TipoReporte> getAllTiposReporte() {
        return tipoReporteRepository.findAll();
    }

    public TipoReporte createTipoReporte(TipoReporte tipoReporte) {
        return tipoReporteRepository.save(tipoReporte);
    }

    public TipoReporte getTipoReporteById(Long id) {
        return tipoReporteRepository.findById(id).orElseThrow(() -> new RuntimeException("Tipo de Reporte no encontrado"));
    }

    public TipoReporte updateTipoReporte(Long id, TipoReporte tipoReporteDetails) {
        TipoReporte tipoReporte = tipoReporteRepository.findById(id).orElseThrow(() -> new RuntimeException("Tipo de Reporte no encontrado"));

        tipoReporte.setNombre(tipoReporteDetails.getNombre());

        return tipoReporteRepository.save(tipoReporte);
    }

    public void deleteTipoReporte(Long id) {
        TipoReporte tipoReporte = tipoReporteRepository.findById(id).orElseThrow(() -> new RuntimeException("Tipo de Reporte no encontrado"));
        tipoReporteRepository.delete(tipoReporte);
    }
}
