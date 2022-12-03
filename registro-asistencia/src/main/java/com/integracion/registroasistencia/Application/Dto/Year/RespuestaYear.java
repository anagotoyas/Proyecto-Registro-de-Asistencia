package com.integracion.registroasistencia.Application.Dto.Year;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Year;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaYear extends Respuesta {

    @JsonProperty("dato")
    Year data;
}
