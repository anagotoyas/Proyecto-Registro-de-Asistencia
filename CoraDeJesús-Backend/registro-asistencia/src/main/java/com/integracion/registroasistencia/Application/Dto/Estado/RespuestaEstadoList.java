package com.integracion.registroasistencia.Application.Dto.Estado;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Estado;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaEstadoList extends Respuesta {

    @JsonProperty("dato")
    List<Estado> data;
}
