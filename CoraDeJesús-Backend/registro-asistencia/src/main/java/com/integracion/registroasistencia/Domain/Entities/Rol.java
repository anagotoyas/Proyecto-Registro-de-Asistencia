package com.integracion.registroasistencia.Domain.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import com.sun.istack.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="roles")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idRol;

    @NotNull
    @Size(min=3,max=50, message="El nombre debe ser minimo 3 caracteres y máximo 50.")
    @Column(name="nombre_rol", nullable = false)
    private String nombreRol;

    @JsonIgnore
    @OneToMany (mappedBy ="rol", cascade ={CascadeType.ALL})
    private List<Usuario> usuarios;
}

