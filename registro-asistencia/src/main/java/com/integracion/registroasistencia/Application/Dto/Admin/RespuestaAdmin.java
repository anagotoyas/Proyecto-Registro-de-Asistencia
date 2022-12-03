package com.integracion.registroasistencia.Application.Dto.Admin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Admin;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaAdmin extends Respuesta {

    @JsonProperty("dato")
    Admin data;

}
