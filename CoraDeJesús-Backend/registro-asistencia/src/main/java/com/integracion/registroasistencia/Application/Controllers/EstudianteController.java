package com.integracion.registroasistencia.Application.Controllers;


import com.integracion.registroasistencia.Application.Dto.Estudiante.EntradaIncidentes;
import com.integracion.registroasistencia.Application.Dto.Estudiante.RespuestaEstudiante;
import com.integracion.registroasistencia.Application.Dto.Estudiante.RespuestaListEstudiante;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Estudiante;
import com.integracion.registroasistencia.Domain.Entities.Grado;
import com.integracion.registroasistencia.Domain.Entities.RegistroAsistencia;
import com.integracion.registroasistencia.Domain.Repositories.EstudianteRepository;
import com.integracion.registroasistencia.Domain.Repositories.GradoRepository;
import com.integracion.registroasistencia.Domain.Repositories.RegistroAsistenciaRepository;
import com.integracion.registroasistencia.Domain.Services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {


    private final EstudianteService estudianteService;


    @Autowired
    private GradoRepository gradoRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private RegistroAsistenciaRepository registroAsistenciaRepository;


    @Value("${spring.mail.username}") private String sender;

    public EstudianteController(EstudianteService estudianteService) {

        this.estudianteService = estudianteService;

    }


    @PostMapping
    public ResponseEntity<RespuestaEstudiante> crearEstudiante(@Valid @RequestBody Estudiante estudiante) {

        RespuestaEstudiante respuesta = new RespuestaEstudiante();

        try {
            Estudiante estudianteNew = estudianteService.crearEstudiante(estudiante);

            respuesta.setMensaje("Estudiante creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(estudianteNew);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){

            respuesta.setMensaje("failed"+e);
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<RespuestaEstudiante> modificarEstudiante(@Valid @RequestBody Estudiante estudiante){

        RespuestaEstudiante respuesta = new RespuestaEstudiante();

        try {
            Estudiante estudianteUpdate = estudianteService.modificarEstudiante(estudiante);

            respuesta.setMensaje("Estudiante modificado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(estudianteUpdate);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idEstudiante}")
    public ResponseEntity<Respuesta> eliminarEstudiante(@PathVariable("idEstudiante") Integer idEstudiante){


        Respuesta respuesta = new Respuesta();

        try {

            estudianteService.eliminarEstudiante(idEstudiante);

            respuesta.setMensaje("Estudiante eliminado con éxito.");
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

    @PutMapping("/{idUsuario}/grado/{idGrado}")
    public Estudiante agregarEstudianteGrado(@PathVariable Integer idUsuario, @PathVariable Integer idGrado) {
        Grado gradoN = gradoRepository.findById(idGrado).get();
        Estudiante estudianteN=estudianteRepository.findById(idUsuario).get();
        estudianteService.agregarEstudianteGrado(estudianteN,gradoN);
        return estudianteRepository.save(estudianteN);

    }

    @GetMapping
    public ResponseEntity<RespuestaListEstudiante> listarEstudiante(){

        RespuestaListEstudiante respuesta = new RespuestaListEstudiante();

        try {
            List<Estudiante> estudiantes = estudianteService.listarEstudiantes();

            respuesta.setMensaje("Lista de estudiantes llamada con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(estudiantes);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/grado/{idGrado}")
    public ResponseEntity<RespuestaListEstudiante> listarEstudianteGrado(@PathVariable Integer idGrado){

        RespuestaListEstudiante respuesta = new RespuestaListEstudiante();

        try {
           // Grado gN = gradoRepository.findById(idGrado).get();

            List<Estudiante> estudiantes1 = estudianteService.obtenerEstudiantesPorGrado(idGrado);

            respuesta.setMensaje("Lista de estudiantes llamada con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(estudiantes1);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){

            respuesta.setMensaje("failed" +e);
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idEstudiante}")
    public ResponseEntity<RespuestaEstudiante> obtenerEstudiantePorIdEstudiante(@PathVariable("idEstudiante") Integer idEstudiante){

        RespuestaEstudiante respuesta = new RespuestaEstudiante();

        try {
            Estudiante estudiante = estudianteService.obtenerEstudiantePorId(idEstudiante);

            respuesta.setMensaje("Estudiante encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(estudiante);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idUsuario}/grado/{idGrado}")
    public Estudiante eliminarEstudianteGrado(@PathVariable Integer idUsuario, @PathVariable Integer idGrado) {
        Grado gradoN = gradoRepository.findById(idGrado).get();
        Estudiante estudianteN = estudianteRepository.findById(idUsuario).get();
        estudianteService.eliminarEstudianteGrado(estudianteN,gradoN);
        return estudianteRepository.save(estudianteN);

    }

    @PostMapping("/notificar/{idRegistroAsistencia}/{idEstudiante}")
    public String enviarCorreo(@PathVariable Integer idRegistroAsistencia, @PathVariable Integer idEstudiante) {
        try {
            RegistroAsistencia registroAsistencia = registroAsistenciaRepository.findById(idRegistroAsistencia).get();
            Estudiante estudianteN = estudianteRepository.findById(idEstudiante).get();
            SimpleMailMessage email = new SimpleMailMessage();
            String content;
            String titulo;

            if (registroAsistencia.getEstado().getIdEstado().equals(2)){
                content="ha llegado tarde a clase";
                titulo = "TARDANZA";
            }
            else {
                content="ha faltado a la clase";
                titulo = "FALTA";
            }

            String nombreCompleto=estudianteN.getNombre() +" "+estudianteN.getApellidoPaterno()+" "+estudianteN.getApellidoPaterno();


            email.setFrom(sender);
            email.setTo("criverac6@upao.edu.pe");
            email.setSubject(titulo);
            email.setText("Sr(a) Apoderado(a) " + estudianteN.getNombreApoderado() +
                    "\nSe le comunica que su menor hijo "+nombreCompleto +" "+content + " de la fecha: "+ registroAsistencia.getFecha());
            mailSender.send(email);

            return "funciona xfa";
        }
        catch (Exception e){
            return "Error" + e.getMessage();
        }


    }
    @GetMapping("tutor/{idTutor}/{idYear}")
    public ResponseEntity<Object> ListarEstudaintesByTutor(@PathVariable("idTutor") Integer idTutor,@PathVariable("idYear") Integer year){
        RespuestaListEstudiante respuesta= new RespuestaListEstudiante();
        try {
            Object estudianteNew = estudianteService.estudainteByTutorYear(idTutor,year);

            respuesta.setMensaje("Estudiante creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
//            respuesta.setData(estudianteNew);

            return new ResponseEntity<>(estudianteNew, HttpStatus.OK);
        } catch (Exception e){
            respuesta.setMensaje("failed"+e);
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping ("incidencias")
    public ResponseEntity<Object> ListarEstudaintesByIndicencias(@RequestBody EntradaIncidentes entradaIncidentes){
        RespuestaListEstudiante respuesta= new RespuestaListEstudiante();
        System.out.println(entradaIncidentes.getFecha());
        try {
            Object estudianteNew = estudianteService.estudaintesByIncidencias(
                    entradaIncidentes.getFecha()
                    ,entradaIncidentes.getGrado());

            respuesta.setMensaje("Estudiante creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
//            respuesta.setData(estudianteNew);

            return new ResponseEntity<>(estudianteNew, HttpStatus.OK);
        } catch (Exception e){
            respuesta.setMensaje("failed"+e);
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }



}
