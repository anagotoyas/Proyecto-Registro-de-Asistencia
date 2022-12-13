package com.integracion.registroasistencia.Domain.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import com.sun.istack.NotNull;

import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="grados")
public class Grado {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idGrado;

    @NotNull
    @Size(min=3,max=50, message="El nombre debe ser minimo 3 caracteres y máximo 50.")
    @Column(name="nombre_grado", nullable = false)
    private String nombreGrado;



    @JsonIgnore
    @ManyToMany(mappedBy = "registrogrado")
    private Set<Estudiante> registrogrado = new LinkedHashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "tutor_grado")
    private Set<Tutor> tutor_grado = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_year", nullable = false,
            foreignKey = @ForeignKey(name = "FK_id_year"))
    private Year year;




}
