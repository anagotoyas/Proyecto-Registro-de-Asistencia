package com.integracion.registroasistencia.Domain.Entities;

import javax.persistence.*;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.validation.constraints.Size;
import java.io.Serializable;

@Table(name = "usuarios")
@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @NotNull
    @Size(min = 8, max = 8, message = "El dni debe contener 8 dígitos.")
    @Column(name = "dni_usuario", nullable = false, unique=true)
    private String dni;

    @NotNull
    @Size(min = 3, max = 100, message = "El nombre debe ser mínimo 3 caracteres y máximo 100.")
    @Column(name = "nombre_usuario", nullable = false)
    private String nombre;

    @NotNull
    @Size(min = 3, max = 100, message = "El apellido debe ser mínimo 3 caracteres y máximo 100.")
    @Column(name = "apaterno_usuario", nullable = false)
    private String apellidoPaterno;

    @NotNull
    @Size(min = 3, max = 100, message = "El apellido debe ser mínimo 3 caracteres y máximo 100.")
    @Column(name = "amaterno_usuario", nullable = false)
    private String apellidoMaterno;

    @NotNull
    @Size(min = 3, max = 10, message = "")
    @Column(name = "sexo_usuario", nullable = false)
    private String sexo;

    @NotNull
    @Size(min = 6, max = 25, message = "La contraseña debe tener como mínimo 6 caracteres")
    @Column(name = "clave_usuario", nullable = false, length = 25)
    private String clave;

    @ManyToOne
    @JoinColumn(name="usuario_rol", nullable = false,
            foreignKey = @ForeignKey(name="FK_usuario_rol"))
    private Rol rol;
}