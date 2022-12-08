package com.integracion.registroasistencia.Application.Dto.Rol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaRol extends Respuesta {

    @JsonProperty("dato")
    Rol data;
}
