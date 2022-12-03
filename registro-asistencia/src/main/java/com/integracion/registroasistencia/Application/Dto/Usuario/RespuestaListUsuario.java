package com.integracion.registroasistencia.Application.Dto.Usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaListUsuario extends Respuesta {
    @JsonProperty("dato")
    List<Usuario> data;

}
