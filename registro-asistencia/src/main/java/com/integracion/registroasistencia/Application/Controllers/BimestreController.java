package com.integracion.registroasistencia.Application.Controllers;

import com.integracion.registroasistencia.Application.Dto.Bimestre.RespuestaBimestre;
import com.integracion.registroasistencia.Application.Dto.Bimestre.RespuestaListBimestre;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Bimestre;
import com.integracion.registroasistencia.Domain.Services.BimestreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bimestres")
public class BimestreController {

    private final BimestreService bimestreService;

    public BimestreController(BimestreService bimestreService) {
        this.bimestreService = bimestreService;
    }

    @PostMapping
    public ResponseEntity<RespuestaBimestre> crearBimestre(@Valid @RequestBody Bimestre bimestre) {

        RespuestaBimestre respuesta = new RespuestaBimestre();

        try {
            Bimestre bimestreNew = bimestreService.crearBimestre(bimestre);

            respuesta.setMensaje("Bimestre creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(bimestreNew);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<RespuestaBimestre> modificarBimestre(@Valid @RequestBody Bimestre bimestre) {

        RespuestaBimestre respuesta = new RespuestaBimestre();

        try {
            Bimestre rolUpdate = bimestreService.modificarBimestre(bimestre);

            respuesta.setMensaje("Bimestre modificado con éxito.");
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

    @DeleteMapping("/{idBimestre}")
    public ResponseEntity<Respuesta> eliminarBimestre(@PathVariable("idBimestre") Integer idBimestre) {


        Respuesta respuesta = new Respuesta();

        try {

            bimestreService.eliminarBimestre(idBimestre);

            respuesta.setMensaje("Bimestre eliminado con éxito");
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
    public ResponseEntity<RespuestaListBimestre> listarBimestre() {

        RespuestaListBimestre respuesta = new RespuestaListBimestre();

        try {
            List<Bimestre> bimestres = bimestreService.listarBimestre();

            respuesta.setMensaje("Listado de bimestres exitoso.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(bimestres);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idBimestre}")
    public ResponseEntity<RespuestaBimestre> obtenerBimestrePorIdBimestre(@PathVariable("idBimestre") Integer idBimestre) {

        RespuestaBimestre respuesta = new RespuestaBimestre();

        try {
            Bimestre bimestre = bimestreService.obtenerBimestrePorIdBimestre(idBimestre);

            respuesta.setMensaje("Bimestre encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(bimestre);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }






}
