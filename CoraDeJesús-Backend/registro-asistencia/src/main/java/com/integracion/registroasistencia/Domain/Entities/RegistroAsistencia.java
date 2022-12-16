package com.integracion.registroasistencia.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "registros_asistencias")
@Getter
@Setter
@ToString
public class RegistroAsistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistro;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "America/Lima")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name="registro_estado", nullable = false,
            foreignKey = @ForeignKey(name="FK_registro_estado"))
    private Estado estado;

    @ManyToOne
    @JoinColumn(name="registro_estudiante", nullable = false,
            foreignKey = @ForeignKey(name="FK_registro_estudiante"))
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name="registro_bimestre", nullable = false,
            foreignKey = @ForeignKey(name="FK_registro_bimestre"))
    private Bimestre bimestre;

    @PrePersist
    public void onCreate() {
        fecha = new Date();

    }
}