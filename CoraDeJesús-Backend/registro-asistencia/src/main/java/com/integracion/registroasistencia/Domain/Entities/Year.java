package com.integracion.registroasistencia.Domain.Entities;

import javax.persistence.*;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "years")
public class Year {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idYear;

    @NotNull
    @Column(name="year", nullable = false)
    private Integer year;

    @NotNull
    @OneToMany (mappedBy ="year", cascade ={CascadeType.ALL})
    private List<Grado> grados;

    @NotNull
    @OneToMany (mappedBy ="year", cascade ={CascadeType.ALL})
    private List<Bimestre> bimestres;
}
