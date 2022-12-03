package com.integracion.registroasistencia.Domain.Services;

import com.integracion.registroasistencia.Domain.Entities.Tutor;
import com.integracion.registroasistencia.Domain.Repositories.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository){
        this.tutorRepository = tutorRepository;
    }

    public Tutor crearTutor(Tutor tutor){
        return tutorRepository.save(tutor);
    }

    public Tutor modificarTutor(Tutor tutor){
        return tutorRepository.save(tutor);
    }

    public void eliminarTutor(Integer idTutor){
        tutorRepository.deleteById(idTutor);
    }

    public List<Tutor> listarTutors(){
        return tutorRepository.findAll();
    }

    public Tutor obtenerTutorPorId(Integer idTutor){
        return tutorRepository.findById(idTutor).orElse(new Tutor());
    }
}
