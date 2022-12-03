package com.integracion.registroasistencia.Domain.Entities;


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
@Table(name="estados")
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idEstado;

    @NotNull
    @Size(min=3,max=50, message="El nombre debe ser minimo 3 caracteres y máximo 50.")
    @Column(name="nombre_estado", nullable = false)
    private String nombreEstado;

    @NotNull
    @OneToMany (mappedBy ="estado", cascade ={CascadeType.ALL})
    private List<RegistroAsistencia> registros;


}
