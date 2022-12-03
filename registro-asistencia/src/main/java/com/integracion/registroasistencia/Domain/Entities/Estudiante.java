package com.integracion.registroasistencia.Domain.Entities;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import com.sun.istack.NotNull;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name="estudiante_grado", nullable = false,
            foreignKey = @ForeignKey(name="FK_estudiante_grado"))
    private Grado grado;

    @NotNull
    @OneToMany (mappedBy ="estudiante", cascade ={CascadeType.ALL})
    private List<RegistroAsistencia> registros;

}
