package com.integracion.registroasistencia.Application.Dto.Estudiante;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Estudiante;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaEstudiante extends Respuesta {

    @JsonProperty("dato")
    Estudiante data;

}
