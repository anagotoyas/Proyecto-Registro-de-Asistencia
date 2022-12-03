package com.integracion.registroasistencia.Application.Dto.RegistroAsistencia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.RegistroAsistencia;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaRegistroAsistencia extends Respuesta {

    @JsonProperty("dato")
    RegistroAsistencia data;
}
