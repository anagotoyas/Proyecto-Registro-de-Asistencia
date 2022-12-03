package com.integracion.registroasistencia.Domain.Repositories;

import com.integracion.registroasistencia.Domain.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findUsuarioByIdUsuarioAndClave(Integer idUsuario, String clave);

    //@Query("SELECT u FROM Usuario u WHERE u.idRol=:idRol")
    //List<Usuario> findAllByRol(@Param("idRol") Integer idRol);




}
