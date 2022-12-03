package com.integracion.registroasistencia.Application.Dto.Admin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Admin;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaListAdmin extends Respuesta {

    @JsonProperty("dato")
    List<Admin> data;

}
