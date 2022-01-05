package com.clinic.service;

import com.clinic.domain.Users;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailService {

//    private final MailCreatorService mailCreatorService;
//    private final JavaMailSender javaMailSender;
//
//    @Autowired
//    public MailService(MailCreatorService mailCreatorService, JavaMailSender javaMailSender) {
//        this.mailCreatorService = mailCreatorService;
//        this.javaMailSender = javaMailSender;
//    }
//
//    public void send(final Mail mail, final Users users) {
//        try {
//            javaMailSender.send(createMimeMessage(mail, users));
//        } catch (MailException e) {
//            LoggerFactory.getLogger(MailService.class).error(e.getMessage());
//        }
//    }
//
//    private MimeMessagePreparator createMimeMessage(final Mail mail, Users users) {
//        return mimeMessage -> {
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
//            mimeMessageHelper.setTo(mail.getMailTo());
//            mimeMessageHelper.setSubject(mail.getSubject());
//            mimeMessageHelper.setText(mailCreatorService.buildNewUserMail(mail.getMessage(), users));
//        };
//    }
}
