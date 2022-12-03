package com.integracion.registroasistencia.Application.Controllers;

import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Application.Dto.Rol.RespuestaListRol;
import com.integracion.registroasistencia.Application.Dto.Rol.RespuestaRol;
import com.integracion.registroasistencia.Domain.Entities.Rol;
import com.integracion.registroasistencia.Domain.Services.RolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping
    public ResponseEntity<RespuestaRol> crearRol(@Valid @RequestBody Rol rol) {

        RespuestaRol respuesta = new RespuestaRol();

        try {
            Rol rolNew = rolService.crearRol(rol);

            respuesta.setMensaje("Rol creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(rolNew);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<RespuestaRol> modificarRol(@Valid @RequestBody Rol rol) {

        RespuestaRol respuesta = new RespuestaRol();

        try {
            Rol rolUpdate = rolService.modificarRol(rol);

            respuesta.setMensaje("Rol modificado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(rolUpdate);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idRol}")
    public ResponseEntity<Respuesta> eliminarRol(@PathVariable("idRol") Integer idRol) {


        Respuesta respuesta = new Respuesta();

        try {

            rolService.eliminarRol(idRol);

            respuesta.setMensaje("Rol eliminado con éxito");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<RespuestaListRol> listarRol() {

        RespuestaListRol respuesta = new RespuestaListRol();

        try {
            List<Rol> roles = rolService.listarRol();

            respuesta.setMensaje("Listado de roles exitoso.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(roles);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idRol}")
    public ResponseEntity<RespuestaRol> obtenerRolPorIdRol(@PathVariable("idRol") Integer idRol) {

        RespuestaRol respuesta = new RespuestaRol();

        try {
            Rol rol = rolService.obtenerRolPorIdRol(idRol);

            respuesta.setMensaje("Rol encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(rol);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }


}
