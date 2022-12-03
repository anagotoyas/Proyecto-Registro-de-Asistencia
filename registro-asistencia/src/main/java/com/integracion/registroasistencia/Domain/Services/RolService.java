package com.integracion.registroasistencia.Domain.Services;

import com.integracion.registroasistencia.Domain.Entities.Rol;
import com.integracion.registroasistencia.Domain.Repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RolService {
    private final RolRepository rolRepository;


    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol modificarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public void eliminarRol(Integer idRol) {
        rolRepository.deleteById(idRol);
    }

    public List<Rol> listarRol() {
        return rolRepository.findAll();
    }

    public Rol obtenerRolPorIdRol(Integer idRol) {
        return rolRepository.findById(idRol).orElse(new Rol());
    }
}