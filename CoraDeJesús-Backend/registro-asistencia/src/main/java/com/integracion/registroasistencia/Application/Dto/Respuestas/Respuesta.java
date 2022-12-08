package com.integracion.registroasistencia.Application.Dto.Respuestas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Respuesta {

    @JsonProperty("satisfactorio")
    boolean satisfactorio;
    @JsonProperty("codigo")
    String codigo;
    @JsonProperty("mensaje")
    String mensaje;

}
