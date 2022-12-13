package com.integracion.registroasistencia.Application.Controllers;


import com.integracion.registroasistencia.Application.Dto.Estudiante.RespuestaListEstudiante;
import com.integracion.registroasistencia.Application.Dto.Grado.RespuestaGrado;
import com.integracion.registroasistencia.Application.Dto.Grado.RespuestaGradoList;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Estudiante;
import com.integracion.registroasistencia.Domain.Entities.Grado;
import com.integracion.registroasistencia.Domain.Entities.RegistroAsistencia;
import com.integracion.registroasistencia.Domain.Services.GradoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/grados")
public class GradoController {

    private final GradoService gradoService;

    public GradoController(GradoService gradoService) {
        this.gradoService = gradoService;
    }

    @PostMapping
    public ResponseEntity<RespuestaGrado> crearGrado(@Valid @RequestBody Grado grado) {

        RespuestaGrado respuesta = new RespuestaGrado();

        try {
            Grado gradoNew = gradoService.crearGrado(grado);

            respuesta.setMensaje("Grado creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(gradoNew);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<RespuestaGrado> modificarGrado(@Valid @RequestBody Grado grado) {

        RespuestaGrado respuesta = new RespuestaGrado();

        try {
            Grado gradoUpdate = gradoService.modificarGrado(grado);

            respuesta.setMensaje("Grado modificado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(gradoUpdate);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idGrado}")
    public ResponseEntity<Respuesta> eliminarGrado(@PathVariable("idGrado") Integer idGrado) {


        Respuesta respuesta = new Respuesta();

        try {

            gradoService.eliminarGrado(idGrado);

            respuesta.setMensaje("Grado eliminado con éxito");
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
    public ResponseEntity<RespuestaGradoList> listarGrado() {

        RespuestaGradoList respuesta = new RespuestaGradoList();

        try {
            List<Grado> grados = gradoService.listarGrado();

            respuesta.setMensaje("Listado de grados exitoso.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(grados);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idGrado}")
    public ResponseEntity<RespuestaGrado> obtenerGradoPorIdGrado(@PathVariable("idGrado") Integer idGrado) {

        RespuestaGrado respuesta = new RespuestaGrado();

        try {
            Grado grado = gradoService.obtenerGradoPorIdGrado(idGrado);

            respuesta.setMensaje("Grado encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(grado);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/estudiantes/{idGrado}")
    public ResponseEntity<RespuestaListEstudiante> obtenerEstudiantesPorGrado(@PathVariable("idGrado") Integer idGrado) {

        RespuestaListEstudiante respuesta = new RespuestaListEstudiante();

        try {
            List<Estudiante> estudiantes = gradoService.obtenerEstudiantesPorGrado(idGrado);

            respuesta.setMensaje("Lista de estudiantes llamada con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(estudiantes);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400" +e);

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }




}
