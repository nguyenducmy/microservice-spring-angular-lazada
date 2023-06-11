package com.example.authenticate.service;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.*;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

@Configuration
public class EmailService {
    @Autowired
    Session session;
    public void send(String emailTo, String text) throws MessagingException, IOException, TemplateException {
        MimeMailMessage mailMessage = new MimeMailMessage(new MimeMessage(session));
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage.getMimeMessage());
        messageHelper.setFrom("myn100890@gmail.com");
        messageHelper.setTo(emailTo);
        messageHelper.setSubject("Lazada User Registed Successfully");

        HashMap<String, String> info = new HashMap<>();
        info.put("username", text);
        freemarker.template.Configuration config = new freemarker.template.Configuration();
        config.setClassLoaderForTemplateLoading(this.getClass().getClassLoader(), "/templates");
        Template template =config.getTemplate("mail.ftl");
        String body = FreeMarkerTemplateUtils.processTemplateIntoString(template, info);
        messageHelper.setText(body, true);
        Transport.send(mailMessage.getMimeMessage());
    }
    @Bean
    public Session session(){
        String emailFrom = "nguyenducmy1089x@gmail.com";
        String password = "iyhbdzjcvunlmyzy";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailFrom, password);
            }
        };
        Session session = Session.getDefaultInstance(props, auth);
        return session;
    }
}
