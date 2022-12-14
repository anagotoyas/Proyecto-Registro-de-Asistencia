package com.integracion.registroasistencia.Domain.Repositories;

import com.integracion.registroasistencia.Domain.Entities.Bimestre;
import com.integracion.registroasistencia.Domain.Entities.Estudiante;
import com.integracion.registroasistencia.Domain.Entities.Grado;
import com.integracion.registroasistencia.Domain.Entities.RegistroAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Repository
public interface RegistroAsistenciaRepository extends JpaRepository<RegistroAsistencia, Integer> {




    List<RegistroAsistencia> findAllByBimestre(Bimestre bimestre);

    List<RegistroAsistencia> findAllByEstudiante(Estudiante estudiante);

    List<RegistroAsistencia> findAllByFecha(Date fecha);

    List<RegistroAsistencia> findAllByFechaAndAndEstudiante(Date fecha, Estudiante estudiante);


    @Query(value = "select *  from get_numero_faltas(:bimestre, :anio)", nativeQuery = true)
    List<Object> getFaltasBySexto(String bimestre, int anio);





}
