package com.clinic.service;

import com.clinic.domain.Users;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailCreatorService {

    private final TemplateEngine templateEngine;

    public MailCreatorService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String buildNewUserMail(String message, Users users) {
        Context context = new Context();
        context.setVariable("user_name", message);
        context.setVariable("roleName", users.getRole());
        context.setVariable("tasks_url", "http://localhost:8080");
        context.setVariable("button", "Visit website");
        return templateEngine.process("new_user_mail", context);
    }


}
