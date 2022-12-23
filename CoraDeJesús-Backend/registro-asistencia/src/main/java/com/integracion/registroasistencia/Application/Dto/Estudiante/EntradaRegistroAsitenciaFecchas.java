package com.integracion.registroasistencia.Application.Dto.Estudiante;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class EntradaRegistroAsitenciaFecchas {

    private Integer pagina;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "America/Lima")
    private Date fecha;

    private Integer grado;

}
