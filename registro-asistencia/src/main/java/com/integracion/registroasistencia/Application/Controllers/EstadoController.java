package com.integracion.registroasistencia.Application.Controllers;


import com.integracion.registroasistencia.Application.Dto.Estado.RespuestaEstado;
import com.integracion.registroasistencia.Application.Dto.Estado.RespuestaEstadoList;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Estado;
import com.integracion.registroasistencia.Domain.Services.EstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @PostMapping
    public ResponseEntity<RespuestaEstado> crearEstado(@Valid @RequestBody Estado estado) {

        RespuestaEstado respuesta = new RespuestaEstado();

        try {
            Estado EstadoNew = estadoService.crearEstado(estado);

            respuesta.setMensaje("Estado creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(EstadoNew);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<RespuestaEstado> modificarEstado(@Valid @RequestBody Estado estado) {

        RespuestaEstado respuesta = new RespuestaEstado();

        try {
            Estado estadoUpdate = estadoService.modificarEstado(estado);

            respuesta.setMensaje("Estado modificado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(estadoUpdate);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idEstado}")
    public ResponseEntity<Respuesta> eliminarEstado(@PathVariable("idEstado") Integer idEstado) {


        Respuesta respuesta = new Respuesta();

        try {

            estadoService.eliminarEstado(idEstado);

            respuesta.setMensaje("Estado eliminado con éxito");
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
    public ResponseEntity<RespuestaEstadoList> listarEstado() {

        RespuestaEstadoList respuesta = new RespuestaEstadoList();

        try {
            List<Estado> estados = estadoService.listarEstado();

            respuesta.setMensaje("Listado de Estados exitoso.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(estados);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idEstado}")
    public ResponseEntity<RespuestaEstado> obtenerEstadoPorIdEstado(@PathVariable("idEstado") Integer idEstado) {

        RespuestaEstado respuesta = new RespuestaEstado();

        try {
            Estado estado = estadoService.obtenerEstadoPorIdEstado(idEstado);

            respuesta.setMensaje("Estado encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(estado);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }


}
