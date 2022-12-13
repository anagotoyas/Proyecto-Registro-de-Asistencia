package com.integracion.registroasistencia.Domain.Entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import com.sun.istack.NotNull;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Table(name = "estudiantes")
@Getter
@Setter
@ToString
@Entity
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Estudiante extends Usuario  {


    @NotNull
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @NotNull
    @Column(name = "correo", nullable = true)
    private String correo;

    @NotNull
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @NotNull
    @Column(name = "nombre_apoderado", nullable = false)
    private String nombreApoderado;

    @Column(name = "ver")
    private Boolean ver;


    @JsonIgnore
    @OneToMany (mappedBy ="estudiante", cascade ={CascadeType.ALL})
    private List<RegistroAsistencia> registros;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany
    @JoinTable(name = "registrogrado", joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_grado"))
    private Set<Grado> registrogrado = new LinkedHashSet<>();


}
