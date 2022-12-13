package com.integracion.registroasistencia.Domain.Services;

import org.springframework.mail.javamail.JavaMailSender;

public class CorreoService {

    private JavaMailSender mailSender;

    public CorreoService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void Menzaje_assitencia(){

    }
}
