package com.integracion.registroasistencia.Application.Controllers;

import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Application.Dto.Year.RespuestaListYear;
import com.integracion.registroasistencia.Application.Dto.Year.RespuestaYear;
import com.integracion.registroasistencia.Domain.Entities.Year;
import com.integracion.registroasistencia.Domain.Services.YearService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/years")
public class YearController {

    private final YearService yearService;

    public YearController(YearService yearService) {
        this.yearService = yearService;
    }

    @PostMapping
    public ResponseEntity<RespuestaYear> crearYear(@Valid @RequestBody Year year) {

        RespuestaYear respuesta = new RespuestaYear();

        try {
            Year yearNew = yearService.crearYear(year);

            respuesta.setMensaje("Year creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(yearNew);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<RespuestaYear> modificarYear(@Valid @RequestBody Year year) {

        RespuestaYear respuesta = new RespuestaYear();

        try {
            Year yearUpdate = yearService.modificarYear(year);

            respuesta.setMensaje("Year modificado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(yearUpdate);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idYear}")
    public ResponseEntity<Respuesta> eliminarYear(@PathVariable("idRol") Integer idYear) {


        Respuesta respuesta = new Respuesta();

        try {

            yearService.eliminarYear(idYear);

            respuesta.setMensaje("Year eliminado con éxito");
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
    public ResponseEntity<RespuestaListYear> listarYear() {

        RespuestaListYear respuesta = new RespuestaListYear();

        try {
            List<Year> years = yearService.listarYear();

            respuesta.setMensaje("Listado de years exitoso.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(years);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idYear}")
    public ResponseEntity<RespuestaYear> obtenerYearPorIdYear(@PathVariable("idYear") Integer idYear) {

        RespuestaYear respuesta = new RespuestaYear();

        try {
            Year year = yearService.obtenerYearPorIdYear(idYear);

            respuesta.setMensaje("Year encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(year);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/anio/{year}")
    public ResponseEntity<RespuestaYear> obtenerYearPorYear(@PathVariable("year") Integer year) {

        RespuestaYear respuesta = new RespuestaYear();

        try {
            Year year1 = yearService.obtenerYearPorYear(year);

            respuesta.setMensaje("Year encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(year1);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e) {

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }
}
