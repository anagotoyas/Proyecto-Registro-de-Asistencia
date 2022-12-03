package com.integracion.registroasistencia.Application.Dto.Bimestre;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Bimestre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaBimestre extends Respuesta {

    @JsonProperty("dato")
    Bimestre data;
}
