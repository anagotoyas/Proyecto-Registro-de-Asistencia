package com.integracion.registroasistencia.Application.Controllers;

import com.integracion.registroasistencia.Application.Dto.Estudiante.EntradaRegistroAsitenciaFecchas;
import com.integracion.registroasistencia.Application.Dto.Estudiante.RespuestaListEstudiante;
import com.integracion.registroasistencia.Application.Dto.RegistroAsistencia.RespuestaListRegistroAsistencia;
import com.integracion.registroasistencia.Application.Dto.RegistroAsistencia.RespuestaRegistroAsistencia;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Bimestre;
import com.integracion.registroasistencia.Domain.Entities.Estudiante;
import com.integracion.registroasistencia.Domain.Entities.Grado;
import com.integracion.registroasistencia.Domain.Entities.RegistroAsistencia;
import com.integracion.registroasistencia.Domain.Repositories.BimestreRepository;
import com.integracion.registroasistencia.Domain.Repositories.EstudianteRepository;
import com.integracion.registroasistencia.Domain.Repositories.GradoRepository;
import com.integracion.registroasistencia.Domain.Repositories.RegistroAsistenciaRepository;
import com.integracion.registroasistencia.Domain.Services.RegistroAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/registro_asistencias")
public class RegistroAsistenciaController {

    private final RegistroAsistenciaService registroAsistenciaService;

    @Autowired
    private BimestreRepository bimestreRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private GradoRepository gradoRepository;

    @Autowired
    private RegistroAsistenciaRepository registroAsistenciaRepository;

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

            respuesta.setMensaje("failed"+e);
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


    @GetMapping("faltas/{bimestre}/{anio}")
    public ResponseEntity<Object> getFaltasBySexo(@PathVariable("bimestre") String bimestre, @PathVariable("anio") Integer anio) {

        RespuestaListRegistroAsistencia respuesta = new RespuestaListRegistroAsistencia();

        try {
            Object registroAsistencias = registroAsistenciaService.getNumeroFaltas(bimestre, anio);

            respuesta.setMensaje("Listado de Registro Asistencias exitoso.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");

            return new ResponseEntity<>(registroAsistencias, HttpStatus.OK);

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

    @GetMapping("/bimestre/{idBimestre}")
    public ResponseEntity<RespuestaListRegistroAsistencia> listarRegistroAsistenciaBimestre(@PathVariable Integer idBimestre){

        RespuestaListRegistroAsistencia respuesta = new RespuestaListRegistroAsistencia();


        try {

            Bimestre bimN = bimestreRepository.findById(idBimestre).get();

            List<RegistroAsistencia> registroAsistencia = registroAsistenciaService.findAllbyBimestre(bimN);

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

    @GetMapping("/estudiante/{idUsuario}")
    public ResponseEntity<RespuestaListRegistroAsistencia> listarRegistroAsistenciaEstudiante(@PathVariable Integer idUsuario){

        RespuestaListRegistroAsistencia respuesta = new RespuestaListRegistroAsistencia();


        try {

            Estudiante esN = estudianteRepository.findById(idUsuario).get();

            List<RegistroAsistencia> registroAsistencia = registroAsistenciaService.findAllByEstudiante(esN);

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

    @GetMapping("/estudiante/{idUsuario}/bimestre/{idBimestre}")
    public ResponseEntity<RespuestaListRegistroAsistencia> listarRegistroAsistenciaEstudianteBim(@PathVariable Integer idUsuario,@PathVariable Integer idBimestre){

        RespuestaListRegistroAsistencia respuesta = new RespuestaListRegistroAsistencia();


        try {

            Estudiante esN = estudianteRepository.findById(idUsuario).get();
            Bimestre bN = bimestreRepository.findById(idBimestre).get();
            List<RegistroAsistencia> registroAsistencia = registroAsistenciaService.obtenerPorEstudianteBimestre(esN,bN);

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

    @GetMapping("/grado/{idGrado}")
    public ResponseEntity<RespuestaListRegistroAsistencia> listarRegistroPorGrado(@PathVariable Integer idGrado){

        RespuestaListRegistroAsistencia respuesta = new RespuestaListRegistroAsistencia();


        try {

            Grado gN = gradoRepository.findById(idGrado).get();

            List<RegistroAsistencia> registroAsistencia = registroAsistenciaService.obtenerPorGrado(gN);

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

    @GetMapping("/grado/{idGrado}/fecha/{fecha}")
    public ResponseEntity<RespuestaListRegistroAsistencia> listarRegistroPorGrado(@PathVariable Integer idGrado, @PathVariable String fecha){

        RespuestaListRegistroAsistencia respuesta = new RespuestaListRegistroAsistencia();


        try {
            Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(fecha);

            Grado gN = gradoRepository.findById(idGrado).get();

            List<RegistroAsistencia> registroAsistencia = registroAsistenciaService.obtenerPorGradoYFecha(gN,date1);

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

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<RespuestaListRegistroAsistencia> listarRegistroAsistenciaFecha(@PathVariable Date fecha){

        RespuestaListRegistroAsistencia respuesta = new RespuestaListRegistroAsistencia();


        try {



            List<RegistroAsistencia> registroAsistencia = registroAsistenciaService.findAllByFecha(fecha);

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
    @PutMapping("Fechas/Bimestre")
    public ResponseEntity<Object> getRegistroAsistenciaByFechaAndBimestreIndice(@RequestBody EntradaRegistroAsitenciaFecchas entradaRegistroAsitenciaFecchas){
        RespuestaListEstudiante respuesta= new RespuestaListEstudiante();
        try {
            Object estudianteNew = registroAsistenciaService.getRegistroAsistenciaByFechaAndBimestreIndice(
                    entradaRegistroAsitenciaFecchas.getPagina()
                    ,entradaRegistroAsitenciaFecchas.getFecha()
                    ,entradaRegistroAsitenciaFecchas.getGrado());

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

    @GetMapping("Grado/{idGrado}/Estudiante/{idEstudiante}/Bimestre/{idBimestre}")
    public ResponseEntity<Object> ggetRegistroLisByEstudeintesYearGrado(
            @PathVariable("idGrado") Integer grado,
            @PathVariable("idEstudiante") Integer estudiante,
            @PathVariable("idBimestre")Integer bimestre)
    {
        RespuestaListEstudiante respuesta= new RespuestaListEstudiante();
        try {
            Object estudianteNew = registroAsistenciaService.getRegistroLisByEstudeintesYearGrado(grado,estudiante,bimestre);

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






