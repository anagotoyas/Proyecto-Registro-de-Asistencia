package com.integracion.registroasistencia.Domain.Services;

import com.integracion.registroasistencia.Domain.Entities.Year;
import com.integracion.registroasistencia.Domain.Repositories.YearRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YearService {

    private final YearRepository yearRepository;

    public YearService(YearRepository yearRepository) {
        this.yearRepository = yearRepository;
    }

    public Year crearYear(Year year) {
        return yearRepository.save(year);
    }

    public Year modificarYear(Year year) {
        return yearRepository.save(year);
    }

    public void eliminarYear(Integer idYear) {
        yearRepository.deleteById(idYear);
    }

    public List<Year> listarYear() {
        return yearRepository.findAll();
    }

    public Year obtenerYearPorIdYear(Integer idYear) {
        return yearRepository.findById(idYear).orElse(new Year());
    }

    public Year obtenerYearPorYear(Integer year) {
        return yearRepository.findYearByYear(year);
    }
}
