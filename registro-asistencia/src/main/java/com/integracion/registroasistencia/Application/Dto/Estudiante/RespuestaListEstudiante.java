package com.integracion.registroasistencia.Application.Dto.Estudiante;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Estudiante;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaListEstudiante extends Respuesta {

    @JsonProperty("dato")
    List<Estudiante> data;

}

