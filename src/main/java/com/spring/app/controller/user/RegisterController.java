package com.spring.app.controller.user;

import com.spring.app.controller.AbstractController;
import com.spring.app.entity.User;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController extends AbstractController {
    private final static String PAGE = WEB + "register";
    private final static String REDIRECT_PAGE = REDIRECT + "register";

    private final JavaMailSender javaMailSender;

    public RegisterController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @GetMapping("/register")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(PAGE);
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("tamvv3");
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("LOL");
        mailMessage.setText("Con me may nha!");

        javaMailSender.send(mailMessage);

        return REDIRECT_PAGE;
    }
}
