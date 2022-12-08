package com.integracion.registroasistencia.Application.Dto.Tutor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Tutor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaTutor extends Respuesta {

    @JsonProperty("dato")
    Tutor data;

}