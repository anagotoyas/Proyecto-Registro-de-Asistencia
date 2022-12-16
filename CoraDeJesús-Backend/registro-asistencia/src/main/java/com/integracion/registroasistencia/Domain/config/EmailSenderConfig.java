package com.integracion.registroasistencia.Domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailSenderConfig {

    @Bean("javaMailSender")
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl sender = new JavaMailSenderImpl();

        sender.setHost("smtp.gmail.com");
        sender.setPort(587);
        sender.setProtocol("smtp");
        sender.setUsername("corazondejesus981@gmail.com");
        sender.setPassword("trfpsqfmmfokujln");

        Properties props = sender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required","true");
        props.put("mail.smtp.quitwait","false");
        props.put("mail.debug", "true");

        return sender;
    }
}
