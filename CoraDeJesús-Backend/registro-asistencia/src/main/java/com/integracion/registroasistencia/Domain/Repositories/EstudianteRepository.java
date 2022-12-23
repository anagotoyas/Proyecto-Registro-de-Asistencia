package com.integracion.registroasistencia.Domain.Repositories;

import com.integracion.registroasistencia.Domain.Entities.Estudiante;
import com.integracion.registroasistencia.Domain.Entities.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {



    //User findUserByStatusAndName(Integer status, String name);


    //List<Estudiante> findAllByGrados(HashSet<Grado> grado);

    @Query(value = "SELECT * FROM get_estudiantes_tutor_year(:year, :tutor)",nativeQuery = true)
    public  List<Object> estudianteListByTutorYear(@Param("tutor")Integer tutor, @Param("year")Integer year);

    @Query(value ="SELECT * FROM  get_estudiantes_incidentes_by_fecha_grado(:date, :grado)" ,nativeQuery = true)
    List<Object> estudianteincidenteFechaGrado(@Param("date") Date fecha, @Param("grado") Integer grado);
}