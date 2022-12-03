package com.integracion.registroasistencia.Domain.Services;

import com.integracion.registroasistencia.Domain.Entities.Estudiante;
import com.integracion.registroasistencia.Domain.Repositories.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;


    public EstudianteService(EstudianteRepository estudianteRepository){
        this.estudianteRepository = estudianteRepository;

    }


    public Estudiante crearEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public Estudiante modificarEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public void eliminarEstudiante(Integer idEstudiante){
        estudianteRepository.deleteById(idEstudiante);
    }

    public List<Estudiante> listarEstudiantes(){
        return estudianteRepository.findAll();
    }

    public Estudiante obtenerEstudiantePorId(Integer idEstudiante){
        return estudianteRepository.findById(idEstudiante).orElse(new Estudiante());
    }

}