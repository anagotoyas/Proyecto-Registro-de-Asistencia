package com.integracion.registroasistencia.Application.Controllers;

import com.integracion.registroasistencia.Application.Dto.RegistroAsistencia.RespuestaListRegistroAsistencia;
import com.integracion.registroasistencia.Application.Dto.RegistroAsistencia.RespuestaRegistroAsistencia;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.RegistroAsistencia;
import com.integracion.registroasistencia.Domain.Services.RegistroAsistenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/registro_asistencias")
public class RegistroAsistenciaController {

    private final RegistroAsistenciaService registroAsistenciaService;

    public RegistroAsistenciaController(RegistroAsistenciaService registroAsistenciaService) {
        this.registroAsistenciaService = registroAsistenciaService;
    }

    @PostMapping
    public ResponseEntity<RespuestaRegistroAsistencia> crearRegistroAsistencia(@Valid @RequestBody RegistroAsistencia registroAsistencia) {

        RespuestaRegistroAsistencia respuesta = new RespuestaRegistroAsistencia();

        try {
            RegistroAsistencia registroAsistenciaNew = registroAsistenciaService.crearRegistroAsistencia(registroAsistencia);

            respuesta.setMensaje("Registro Asistencia creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(registroAsistenciaNew);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<RespuestaRegistroAsistencia> modificarRegistroAsistencia(@Valid @RequestBody RegistroAsistencia registroAsistencia) {

        RespuestaRegistroAsistencia respuesta = new RespuestaRegistroAsistencia();

        try {
            RegistroAsistencia rolUpdate = registroAsistenciaService.modificarRegistroAsistencia(registroAsistencia);

            respuesta.setMensaje("Registro Asistencia modificado con éxito.");
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

    @DeleteMapping("/{idRegistroAsistencia}")
    public ResponseEntity<Respuesta> eliminarRegistroAsistencia(@PathVariable("idRegistroAsistencia") Integer idRegistroAsistencia) {


        Respuesta respuesta = new Respuesta();

        try {

            registroAsistenciaService.eliminarRegistroAsistencia(idRegistroAsistencia);

            respuesta.setMensaje("RegistroAsistencia eliminado con éxito");
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
    public ResponseEntity<RespuestaListRegistroAsistencia> listarRegistroAsistencia() {

        RespuestaListRegistroAsistencia respuesta = new RespuestaListRegistroAsistencia();

        try {
            List<RegistroAsistencia> registroAsistencias = registroAsistenciaService.listarRegistroAsistencia();

            respuesta.setMensaje("Listado de Registro Asistencias exitoso.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(registroAsistencias);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idRegistroAsistencia}")
    public ResponseEntity<RespuestaRegistroAsistencia> obtenerRegistroAsistenciaPorIdRegistroAsistencia(@PathVariable("idRegistroAsistencia") Integer idRegistroAsistencia) {

        RespuestaRegistroAsistencia respuesta = new RespuestaRegistroAsistencia();

        try {
            RegistroAsistencia registroAsistencia = registroAsistenciaService.obtenerRegistroAsistenciaPorIdRegistroAsistencia(idRegistroAsistencia);

            respuesta.setMensaje("RegistroAsistencia encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(registroAsistencia);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }


}
