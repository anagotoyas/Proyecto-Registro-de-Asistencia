package com.integracion.registroasistencia.Domain.Entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import com.sun.istack.NotNull;


@Getter
@Setter
@ToString
@Entity
@Table(name = "tutores")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Tutor extends Usuario{


    @ManyToOne
    @JoinColumn(name="tutor_grado", nullable = false,
            foreignKey = @ForeignKey(name="FK_tutor_grado"))
    private Grado grado;

}
