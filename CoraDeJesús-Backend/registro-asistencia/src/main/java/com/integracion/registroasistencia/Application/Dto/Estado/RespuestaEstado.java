package com.integracion.registroasistencia.Application.Dto.Estado;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Estado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaEstado extends Respuesta {

    @JsonProperty("dato")
    Estado data;
}
