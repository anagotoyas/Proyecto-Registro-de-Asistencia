package com.integracion.registroasistencia.Domain.Services;

import com.integracion.registroasistencia.Domain.Entities.Estudiante;
import com.integracion.registroasistencia.Domain.Entities.RegistroAsistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class CorreoService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EstudianteService estudianteService;

    public void Menzaje_assitencia(RegistroAsistencia registroAsistencia){
        Integer id=registroAsistencia.getEstudiante().getIdUsuario();
        System.out.println(id);
        Estudiante estudiante= estudianteService.obtenerEstudiantePorId(id);
        System.out.println(estudiante);

        String content;
        if(registroAsistencia.getEstado().getNombreEstado().equals("TARDANZA")){
            content="llego tarde a clase";
        }
        else {
            content="falto a la clase";
        }
        String nombreCompleto=estudiante.getNombre() +" "+estudiante.getApellidoPaterno()+" "+estudiante.getApellidoPaterno();
        Locale locale = new Locale("es", "PE");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy",locale);
        String date = dateFormat.format(registroAsistencia.getFecha());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("corazondejesus981@gmail.com");
        message.setTo("pixgel13040@gmail.com");
        message.setSubject(registroAsistencia.getEstado().getNombreEstado());
        message.setText("Se le comunica que su menor hijo "+nombreCompleto +" "+content + " en la fecha: "+ date);
        mailSender.send(message);
    }
}
