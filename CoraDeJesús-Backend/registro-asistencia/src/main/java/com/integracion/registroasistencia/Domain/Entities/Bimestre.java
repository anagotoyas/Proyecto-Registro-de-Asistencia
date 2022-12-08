package com.integracion.registroasistencia.Domain.Entities;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import com.sun.istack.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="bimestres")
public class Bimestre {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idBimestre;

    @NotNull
    @Column(name="nombre_bimestre", nullable = false)
    private String nombreBimestre;

    @ManyToOne
    @JoinColumn(name="bimestre_year", nullable = false,
            foreignKey = @ForeignKey(name="FK_bimestre_year"))
    private Year year;

    @NotNull
    @OneToMany (mappedBy ="bimestre", cascade ={CascadeType.ALL})
    private List<RegistroAsistencia> registros;
}
