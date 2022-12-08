package com.integracion.registroasistencia.Domain.Services;

import com.integracion.registroasistencia.Domain.Entities.Estado;
import com.integracion.registroasistencia.Domain.Repositories.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;


    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }



    public Estado crearEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    public Estado modificarEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void eliminarEstado(Integer idEstado) {
        estadoRepository.deleteById(idEstado);
    }

    public List<Estado> listarEstado() {
        return estadoRepository.findAll();
    }

    public Estado obtenerEstadoPorIdEstado(Integer idEstado) {
        return estadoRepository.findById(idEstado).orElse(new Estado());
    }

}
