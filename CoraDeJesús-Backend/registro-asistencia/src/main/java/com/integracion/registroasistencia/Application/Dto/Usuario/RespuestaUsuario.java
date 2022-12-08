package com.integracion.registroasistencia.Application.Dto.Usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaUsuario extends Respuesta {
    @JsonProperty("dato")
    Usuario data;

}
