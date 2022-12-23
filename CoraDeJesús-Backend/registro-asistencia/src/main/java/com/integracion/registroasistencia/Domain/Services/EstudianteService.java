package com.integracion.registroasistencia.Domain.Services;

import com.integracion.registroasistencia.Domain.Entities.Estudiante;
import com.integracion.registroasistencia.Domain.Entities.Grado;
import com.integracion.registroasistencia.Domain.Repositories.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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

    public void agregarEstudianteGrado(Estudiante estudiante, Grado grado) {
        estudiante.getRegistrogrado().add(grado);
    }

    public void eliminarEstudianteGrado(Estudiante estudiante, Grado grado) {
        estudiante.getRegistrogrado().remove(grado);

    }

    public List<Estudiante> obtenerEstudiantesPorGrado(Integer idGrado){

        List<Estudiante> todos = estudianteRepository.findAll();
        List<Estudiante> porGrado = todos.stream().filter(
                a -> a.getRegistrogrado().stream().anyMatch(
                        c->c.getIdGrado().equals(idGrado))).collect(Collectors.toList());
       return porGrado;
    }

    public  List<Object> estudainteByTutorYear(Integer tutor, Integer year){
        return estudianteRepository.estudianteListByTutorYear(tutor, year);
    }

    public List<Object> estudaintesByIncidencias(Date fecha, Integer grado){
        System.out.println(fecha);
        return  estudianteRepository.estudianteincidenteFechaGrado(fecha,grado);
    }



}