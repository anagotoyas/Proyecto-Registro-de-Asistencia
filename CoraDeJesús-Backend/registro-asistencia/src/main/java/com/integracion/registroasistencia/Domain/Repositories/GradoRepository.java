package com.integracion.registroasistencia.Domain.Repositories;

import com.integracion.registroasistencia.Domain.Entities.Estudiante;
import com.integracion.registroasistencia.Domain.Entities.Grado;
import com.integracion.registroasistencia.Domain.Entities.RegistroAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradoRepository  extends JpaRepository<Grado, Integer> {

    List<Estudiante> findAllByIdGrado(Integer idGrado);


    @Query(value = "SELECT " +
            "grados.id_grado, " +
            "grados.nombre_grado, " +
            "grados.id_year " +
            "FROM " +
            "estudiantes " +
            "LEFT JOIN registrogrado ON registrogrado.id_usuario = estudiantes.id_usuario " +
            "LEFT JOIN grados ON grados.id_grado = registrogrado.id_grado "+
            "WHERE estudiantes.id_usuario=:idEstudiante"
            ,nativeQuery = true)
    List<Grado> GradosPorEstudiante(@Param("idEstudiante") Integer idEstudiante);




}
