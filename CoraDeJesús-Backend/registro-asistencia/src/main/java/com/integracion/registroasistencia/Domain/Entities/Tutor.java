package com.integracion.registroasistencia.Domain.Entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import com.sun.istack.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;


@Getter
@Setter
@ToString
@Entity
@Table(name = "tutores")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Tutor extends Usuario{



    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany
    @JoinTable(name = "tutor_grado", joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_grado"))
    Set<Grado> tutor_grado = new LinkedHashSet<>();

}
