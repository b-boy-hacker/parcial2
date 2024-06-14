package com.example.examen2.carrera.controller;

import com.example.examen2.carrera.model.CarreraDT0;
import com.example.examen2.carrera.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carreras/")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public List<CarreraDT0> getAllCarreras() {
        return carreraService.getAllCarreras();
    }

    @PostMapping
    public CarreraDT0 createCarrera(@RequestBody CarreraDT0 carreraDTO) {
        return carreraService.createCarrera(carreraDTO);
    }

    @GetMapping("/{id}")
    public CarreraDT0 getCarreraById(@PathVariable Long id) {
        return carreraService.getCarreraById(id);
    }

    @PutMapping("/{id}")
    public CarreraDT0 updateCarrera(@PathVariable Long id, @RequestBody CarreraDT0 carreraDTO) {
        return carreraService.updateCarrera(id, carreraDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCarrera(@PathVariable Long id) {
        carreraService.deleteCarrera(id);
    }
}
