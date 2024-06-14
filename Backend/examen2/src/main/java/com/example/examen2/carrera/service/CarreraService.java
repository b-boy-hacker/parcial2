package com.example.examen2.carrera.service;

import com.example.examen2.carrera.model.CarreraDT0;
import com.example.examen2.carrera.model.Facultad;
import com.example.examen2.carrera.model.FacultadDT0;
import com.example.examen2.carrera.model.Carrera;
import com.example.examen2.carrera.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public List<CarreraDT0> getAllCarreras() {
        List<Carrera> carreras = carreraRepository.findAll();
        return carreras.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CarreraDT0 createCarrera(CarreraDT0 carreraDTO) {
        Carrera carrera = new Carrera();
        carrera.setNombre(carreraDTO.getNombre());
        carrera.setCodigo(carreraDTO.getCodigo());
        // set facultad if present
        if (carreraDTO.getFacultad() != null) {
            FacultadDT0 facultadDTO = carreraDTO.getFacultad();
            carrera.setFacultad(new Facultad(facultadDTO.getId(), facultadDTO.getNombre()));
        }
        Carrera savedCarrera = carreraRepository.save(carrera);
        return convertToDTO(savedCarrera);
    }

    public CarreraDT0 getCarreraById(Long id) {
        Carrera carrera = carreraRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrera not found"));
        return convertToDTO(carrera);
    }

    public CarreraDT0 updateCarrera(Long id, CarreraDT0 carreraDTO) {
        Carrera carrera = carreraRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrera not found"));
        carrera.setNombre(carreraDTO.getNombre());
        carrera.setCodigo(carreraDTO.getCodigo());
        // set facultad if present
        if (carreraDTO.getFacultad() != null) {
            FacultadDT0 facultadDTO = carreraDTO.getFacultad();
            carrera.setFacultad(new Facultad(facultadDTO.getId(), facultadDTO.getNombre()));
        }
        Carrera updatedCarrera = carreraRepository.save(carrera);
        return convertToDTO(updatedCarrera);
    }

    public void deleteCarrera(Long id) {
        carreraRepository.deleteById(id);
    }

    private CarreraDT0 convertToDTO(Carrera carrera) {
        CarreraDT0 carreraDTO = new CarreraDT0();
        carreraDTO.setId(carrera.getId());
        carreraDTO.setNombre(carrera.getNombre());
        carreraDTO.setCodigo(carrera.getCodigo());
        if (carrera.getFacultad() != null) {
            FacultadDT0 facultadDTO = new FacultadDT0();
            facultadDTO.setId(carrera.getFacultad().getId());
            facultadDTO.setNombre(carrera.getFacultad().getNombre());
            carreraDTO.setFacultad(facultadDTO);
        }
        return carreraDTO;
    }
}
