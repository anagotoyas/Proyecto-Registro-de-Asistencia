package com.integracion.registroasistencia.Domain.Entities;

import javax.persistence.*;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "administradores")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Admin extends Usuario {

}