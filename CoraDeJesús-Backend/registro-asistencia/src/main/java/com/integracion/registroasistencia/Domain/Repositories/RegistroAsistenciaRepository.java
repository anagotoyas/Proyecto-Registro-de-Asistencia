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


    @Query(value = "select  * from get_asitencias_estudiante_grado(:grado , :estudiante, :bimestre)",nativeQuery = true)
    List<Object> getRegistroListByEstudeintesYearGrado(@Param("grado") Integer grado, @Param("estudiante") Integer estudiante, @Param("bimestre") Integer bimestre);

    @Query(value = "SELECT  * FROM  get_asistencias_by_fechas_bimestres(:indice, :fecha, :bimestre)",nativeQuery = true)
    List<Object> getRegistroAsistenciaByFechaAndBimestreIndice( @Param("indice")Integer indice,@Param("fecha")  Date fecha,@Param("bimestre") Integer bimestre);

    @Query(value = "SELECT * from registros_asistencias, estudiantes, registrogrado where registros_asistencias.registro_estado = 3 and registros_asistencias.registro_estudiante=estudiantes.id_usuario and registrogrado.id_usuario=estudiantes.id_usuario and registrogrado.id_grado = :idGrado", nativeQuery = true)
    List<RegistroAsistencia> getFaltas(@Param("idGrado") Integer idGrado);


}
