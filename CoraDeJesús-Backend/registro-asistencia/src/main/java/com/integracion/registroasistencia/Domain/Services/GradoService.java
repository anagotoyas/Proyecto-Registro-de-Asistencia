package com.integracion.registroasistencia.Domain.Services;

import com.integracion.registroasistencia.Domain.Entities.Estudiante;
import com.integracion.registroasistencia.Domain.Entities.Grado;
import com.integracion.registroasistencia.Domain.Entities.RegistroAsistencia;
import com.integracion.registroasistencia.Domain.Repositories.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GradoService {

    private final GradoRepository gradoRepository;


    public GradoService(GradoRepository gradoRepository) {
        this.gradoRepository = gradoRepository;
    }



    public Grado crearGrado(Grado grado) {
        return gradoRepository.save(grado);
    }

    public Grado modificarGrado(Grado grado) {
        return gradoRepository.save(grado);
    }

    public void eliminarGrado(Integer idGrado) {
        gradoRepository.deleteById(idGrado);
    }

    public List<Grado> listarGrado() {
        return gradoRepository.findAll();
    }

    public Grado obtenerGradoPorIdGrado(Integer idGrado) {
        return gradoRepository.findById(idGrado).orElse(new Grado());
    }

    public List<Estudiante> obtenerEstudiantesPorGrado(Integer idGrado){
        return gradoRepository.findAllByIdGrado(idGrado);
    }

    public  List<Grado> obtenerGradoEstudiante(Integer idEstudiante){
        return gradoRepository.GradosPorEstudiante(idEstudiante);
    }


}
