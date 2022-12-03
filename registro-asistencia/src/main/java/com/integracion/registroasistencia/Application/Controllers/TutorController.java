package com.integracion.registroasistencia.Application.Controllers;


import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Application.Dto.Tutor.RespuestaListTutor;
import com.integracion.registroasistencia.Application.Dto.Tutor.RespuestaTutor;
import com.integracion.registroasistencia.Domain.Entities.Tutor;
import com.integracion.registroasistencia.Domain.Services.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService){
        this.tutorService = tutorService;
    }

    @PostMapping
    public ResponseEntity<RespuestaTutor> registrarTutor(@Valid @RequestBody Tutor tutor){
        RespuestaTutor respuesta = new RespuestaTutor();

        try{
            Tutor tutor1 = tutorService.crearTutor(tutor);

            respuesta.setMensaje("Tutor creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(tutor1);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){
            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<RespuestaTutor> modificarTutor(@Valid @RequestBody Tutor tutor){
        RespuestaTutor respuesta = new RespuestaTutor();

        try{
            Tutor tutor1 = tutorService.modificarTutor(tutor);

            respuesta.setMensaje("Tutor modificado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(tutor1);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){
            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idTutor}")
    public ResponseEntity<Respuesta> eliminarTutor(@PathVariable("idTutor") Integer idTutor){
        Respuesta respuesta = new Respuesta();

        try{
            tutorService.eliminarTutor(idTutor);

            respuesta.setMensaje("Tutor eliminado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");

            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e){
            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<RespuestaListTutor> listarTutors(){

        RespuestaListTutor respuesta = new RespuestaListTutor();

        try {
            List<Tutor> tutores = tutorService.listarTutors();

            respuesta.setMensaje("Tutores listados con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(tutores);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idTutor}")
    public ResponseEntity<RespuestaTutor> obtenerTutorPorId(@PathVariable("idTutor") Integer idTutor){
        RespuestaTutor respuesta = new RespuestaTutor();

        try {
            Tutor tutor = tutorService.obtenerTutorPorId(idTutor);

            respuesta.setMensaje("Tutor encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(tutor);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

}
