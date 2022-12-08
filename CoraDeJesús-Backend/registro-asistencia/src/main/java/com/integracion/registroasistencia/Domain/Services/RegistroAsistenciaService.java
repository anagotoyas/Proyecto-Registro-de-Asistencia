package com.integracion.registroasistencia.Domain.Services;

import com.integracion.registroasistencia.Domain.Entities.RegistroAsistencia;
import com.integracion.registroasistencia.Domain.Repositories.RegistroAsistenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroAsistenciaService {

    private final RegistroAsistenciaRepository registroAsistenciaRepository;


    public RegistroAsistenciaService(RegistroAsistenciaRepository registroAsistenciaRepository) {
        this.registroAsistenciaRepository = registroAsistenciaRepository;
    }



    public RegistroAsistencia crearRegistroAsistencia(RegistroAsistencia RegistroAsistencia) {
        return registroAsistenciaRepository.save(RegistroAsistencia);
    }

    public RegistroAsistencia modificarRegistroAsistencia(RegistroAsistencia RegistroAsistencia) {
        return registroAsistenciaRepository.save(RegistroAsistencia);
    }

    public void eliminarRegistroAsistencia(Integer idRegistroAsistencia) {
        registroAsistenciaRepository.deleteById(idRegistroAsistencia);
    }

    public List<RegistroAsistencia> listarRegistroAsistencia() {
        return registroAsistenciaRepository.findAll();
    }


    public RegistroAsistencia obtenerRegistroAsistenciaPorIdRegistroAsistencia(Integer idRegistroAsistencia) {
        return registroAsistenciaRepository.findById(idRegistroAsistencia).orElse(new RegistroAsistencia());
    }
}
