package com.integracion.registroasistencia.Application.Dto.RegistroAsistencia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.RegistroAsistencia;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaListRegistroAsistencia extends Respuesta {

    @JsonProperty("dato")
    List<RegistroAsistencia> data;
}
