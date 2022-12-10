package com.integracion.registroasistencia.Domain.Entities;

import javax.persistence.*;

@Entity
@Table(name = "estudiante_grado")
public class EstudianteGrado {

    @EmbeddedId
    EstudianteGradoKey id;

    @ManyToOne
    @MapsId(value = "idUsuario")
    @JoinColumn(name ="id_usuario", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @MapsId(value = "idGrado")
    @JoinColumn(name ="id_grado",nullable = false)
    private Grado grado;

    @ManyToOne
    @JoinColumn(name = "id_year", nullable = false)
    private Year year;

}
