package com.integracion.registroasistencia.Domain.Entities;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import com.sun.istack.NotNull;

import javax.validation.constraints.Size;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name="grado_year", nullable = false,
            foreignKey = @ForeignKey(name="FK_grado_year"))
    private Year year;

    @ManyToMany(mappedBy = "grados")
    private List<Estudiante> estudiantes;

    @NotNull
    @OneToMany (mappedBy ="grado", cascade ={CascadeType.ALL})
    private List<Tutor> tutores;



}
