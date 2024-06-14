package com.example.examen2.materia.service;

import com.example.examen2.materia.model.MateriaDTO;
import com.example.examen2.materia.model.Materia;
import com.example.examen2.carrera.model.Carrera;
import com.example.examen2.carrera.model.CarreraDT0;
import com.example.examen2.materia.repository.MateriaRepository;
import com.example.examen2.carrera.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    public List<MateriaDTO> getAllMaterias() {
        List<Materia> materias = materiaRepository.findAll();
        return materias.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public MateriaDTO createMateria(MateriaDTO materiaDTO) {
        Materia materia = new Materia();
        materia.setNombre(materiaDTO.getNombre());
        materia.setCreditos(materiaDTO.getCreditos());
        if (materiaDTO.getCarrera() != null) {
            Carrera carrera = carreraRepository.findById(materiaDTO.getCarrera().getId()).orElseThrow(() -> new RuntimeException("Carrera not found"));
            materia.setCarrera(carrera);
        }
        Materia savedMateria = materiaRepository.save(materia);
        return convertToDTO(savedMateria);
    }

    public MateriaDTO getMateriaById(Long id) {
        Materia materia = materiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Materia not found"));
        return convertToDTO(materia);
    }

    public MateriaDTO updateMateria(Long id, MateriaDTO materiaDTO) {
        Materia materia = materiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Materia not found"));
        materia.setNombre(materiaDTO.getNombre());
        materia.setCreditos(materiaDTO.getCreditos());
        if (materiaDTO.getCarrera() != null) {
            Carrera carrera = carreraRepository.findById(materiaDTO.getCarrera().getId()).orElseThrow(() -> new RuntimeException("Carrera not found"));
            materia.setCarrera(carrera);
        }
        Materia updatedMateria = materiaRepository.save(materia);
        return convertToDTO(updatedMateria);
    }

    public void deleteMateria(Long id) {
        materiaRepository.deleteById(id);
    }

    private MateriaDTO convertToDTO(Materia materia) {
        MateriaDTO materiaDTO = new MateriaDTO();
        materiaDTO.setId(materia.getId());
        materiaDTO.setNombre(materia.getNombre());
        materiaDTO.setCreditos(materia.getCreditos());
        if (materia.getCarrera() != null) {
            CarreraDT0 carreraDTO = new CarreraDT0();
            carreraDTO.setId(materia.getCarrera().getId());
            carreraDTO.setNombre(materia.getCarrera().getNombre());
            carreraDTO.setCodigo(materia.getCarrera().getCodigo());
            materiaDTO.setCarrera(carreraDTO);
        }
        return materiaDTO;
    }
}
