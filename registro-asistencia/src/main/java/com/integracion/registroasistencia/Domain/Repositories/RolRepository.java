package com.integracion.registroasistencia.Domain.Repositories;

import com.integracion.registroasistencia.Domain.Entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

}
