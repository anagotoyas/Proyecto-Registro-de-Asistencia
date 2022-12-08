package com.integracion.registroasistencia.Application.Dto.Tutor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Tutor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaListTutor extends Respuesta {

    @JsonProperty("dato")
    List<Tutor> data;

}
