package com.integracion.registroasistencia.Domain.Services;

import com.integracion.registroasistencia.Domain.Entities.Bimestre;
import com.integracion.registroasistencia.Domain.Repositories.BimestreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BimestreService {

    private final BimestreRepository bimestreRepository;


    public BimestreService(BimestreRepository bimestreRepository) {
        this.bimestreRepository = bimestreRepository;
    }



    public Bimestre crearBimestre(Bimestre bimestre) {
        return bimestreRepository.save(bimestre);
    }

    public Bimestre modificarBimestre(Bimestre bimestre) {
        return bimestreRepository.save(bimestre);
    }

    public void eliminarBimestre(Integer idBimestre) {
        bimestreRepository.deleteById(idBimestre);
    }

    public List<Bimestre> listarBimestre() {
        return bimestreRepository.findAll();
    }



    public Bimestre obtenerBimestrePorIdBimestre(Integer idBimestre) {
        return bimestreRepository.findById(idBimestre).orElse(new Bimestre());
    }
}
