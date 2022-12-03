package com.integracion.registroasistencia.Application.Controllers;


import com.integracion.registroasistencia.Application.Dto.Admin.RespuestaAdmin;
import com.integracion.registroasistencia.Application.Dto.Admin.RespuestaListAdmin;
import com.integracion.registroasistencia.Application.Dto.Respuestas.Respuesta;
import com.integracion.registroasistencia.Domain.Entities.Admin;
import com.integracion.registroasistencia.Domain.Services.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<RespuestaAdmin> registrarAdmin(@Valid @RequestBody Admin admin){
        RespuestaAdmin respuesta = new RespuestaAdmin();

        try{
            Admin admin1 = adminService.crearAdmin(admin);

            respuesta.setMensaje("Admin creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(admin1);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){
            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<RespuestaAdmin> modificarAdmin(@Valid @RequestBody Admin admin){
        RespuestaAdmin respuesta = new RespuestaAdmin();

        try{
            Admin admin1 = adminService.modificarAdmin(admin);

            respuesta.setMensaje("Admin modificado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(admin1);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){
            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idAdmin}")
    public ResponseEntity<Respuesta> eliminarDocente(@PathVariable("idAdmin") Integer idAdmin){
        Respuesta respuesta = new Respuesta();

        try{
            adminService.eliminarAdmin(idAdmin);

            respuesta.setMensaje("Admin eliminado con éxito.");
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
    public ResponseEntity<RespuestaListAdmin> listarAdmins(){

        RespuestaListAdmin respuesta = new RespuestaListAdmin();

        try {
            List<Admin> admins = adminService.listarAdmins();

            respuesta.setMensaje("Admins listados con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(admins);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idAdmin}")
    public ResponseEntity<RespuestaAdmin> obtenerAdminPorId(@PathVariable("idAdmin") Integer idAdmin){
        RespuestaAdmin respuesta = new RespuestaAdmin();

        try {
            Admin admin = adminService.obtenerAdminPorId(idAdmin);

            respuesta.setMensaje("Admin encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(admin);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

}
