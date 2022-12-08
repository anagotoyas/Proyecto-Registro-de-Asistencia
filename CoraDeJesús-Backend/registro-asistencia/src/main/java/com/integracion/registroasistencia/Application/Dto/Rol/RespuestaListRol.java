package com.integracion.registroasistencia.Application.Dto.Rol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Rol;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaListRol extends Respuesta {

    @JsonProperty("dato")
    List<Rol> data;

}
