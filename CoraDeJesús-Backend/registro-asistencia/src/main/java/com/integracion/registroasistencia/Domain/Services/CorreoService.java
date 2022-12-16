package com.integracion.registroasistencia.Domain.Services;

import com.integracion.registroasistencia.Domain.Entities.Estudiante;
import com.integracion.registroasistencia.Domain.Entities.RegistroAsistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CorreoService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EstudianteService estudianteService;

    public void Menzaje_assitencia(Integer idEstudiante, RegistroAsistencia registroAsistencia){
        System.out.println("hola");
        Estudiante estudiante= estudianteService.obtenerEstudiantePorId(idEstudiante);
        System.out.println("hola");
        String content;
        if(registroAsistencia.getEstado().getNombreEstado().equals("TARDANZA")){
            content="llego tarde a clase";
        }
        else {
            content="falto a la clase";
        }
        String nombreCompleto=estudiante.getNombre() +" "+estudiante.getApellidoPaterno()+" "+estudiante.getApellidoPaterno();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("corazondejesus981@gmail.com");
        message.setTo("pixgel13040@gmail.com");
        message.setSubject(registroAsistencia.getEstado().getNombreEstado());
        message.setText("Se le comunica que su menor hijo "+nombreCompleto +" "+content + " en la fecha: "+ registroAsistencia.getFecha().toString());
        mailSender.send(message);
    }
}
