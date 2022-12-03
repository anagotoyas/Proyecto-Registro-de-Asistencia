package com.integracion.registroasistencia.Application.Dto.Grado;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Grado;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaGradoList extends Respuesta {

    @JsonProperty("dato")
    List<Grado> data;
}
