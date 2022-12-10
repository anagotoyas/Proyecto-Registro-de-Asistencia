package com.integracion.registroasistencia.Domain.Entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EstudianteGradoKey implements Serializable {

    @Column(name = "id_usuario")
    private Integer usuarioId;

    @Column(name = "id_grado")
    private Integer gradoId;

}
