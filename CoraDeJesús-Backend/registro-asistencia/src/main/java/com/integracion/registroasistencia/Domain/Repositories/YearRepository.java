package com.integracion.registroasistencia.Domain.Repositories;


import com.integracion.registroasistencia.Domain.Entities.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearRepository  extends JpaRepository<Year, Integer> {

    Year findYearByYear(Integer year);
}
