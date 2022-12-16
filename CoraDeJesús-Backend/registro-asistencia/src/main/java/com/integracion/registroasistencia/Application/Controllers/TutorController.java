package com.integracion.registroasistencia.Application.Controllers;


import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Application.Dto.Tutor.RespuestaListTutor;
import com.integracion.registroasistencia.Application.Dto.Tutor.RespuestaTutor;
import com.integracion.registroasistencia.Domain.Entities.Estudiante;
import com.integracion.registroasistencia.Domain.Entities.Grado;
import com.integracion.registroasistencia.Domain.Entities.RegistroAsistencia;
import com.integracion.registroasistencia.Domain.Entities.Tutor;
import com.integracion.registroasistencia.Domain.Repositories.EstudianteRepository;
import com.integracion.registroasistencia.Domain.Repositories.GradoRepository;
import com.integracion.registroasistencia.Domain.Repositories.TutorRepository;
import com.integracion.registroasistencia.Domain.Services.CorreoService;
import com.integracion.registroasistencia.Domain.Services.TutorService;
import com.integracion.registroasistencia.Utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    private final TutorService tutorService;

    private final CorreoService correoService;

    @Autowired
    private GradoRepository gradoRepository;

    @Autowired
    private TutorRepository tutorRepository;
    public TutorController(TutorService tutorService, CorreoService correoService){
        this.tutorService = tutorService;
        this.correoService= correoService;
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

    @GetMapping("/correo/{idEstudiante}")
    public  ResponseEntity<Respuesta> enviarCorreo(@PathVariable("idEstudiante")Integer idEstudiante,@RequestBody RegistroAsistencia asistencias){
        Respuesta respuesta = new Respuesta();
        try{
            System.out.println(idEstudiante);
            System.out.println(asistencias);
            correoService.Menzaje_assitencia(idEstudiante,asistencias);

            respuesta.setMensaje("Correo enviado con exito");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        }
        catch (Exception e){
            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");
            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{idUsuario}/grado/{idGrado}")
    public Tutor agregarTutorGrado(@PathVariable Integer idUsuario, @PathVariable Integer idGrado) {
        Grado gradoN = gradoRepository.findById(idGrado).get();
        Tutor tutorN=tutorRepository.findById(idUsuario).get();
        tutorService.agregarTutorGrado(tutorN,gradoN);
        return tutorRepository.save(tutorN);

    }

}
