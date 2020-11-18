package com.spring.app.controller.user;

import com.spring.app.controller.AbstractController;
import com.spring.app.entity.User;
import com.spring.app.model.Message;
import com.spring.app.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j2
public class RegisterController extends AbstractController {
    private final static String PAGE = WEB + "register";

    private final JavaMailSender javaMailSender;
    private final UserService userService;

    public RegisterController(JavaMailSender javaMailSender, UserService userService) {
        this.javaMailSender = javaMailSender;
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(PAGE);
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {

        Message message = userService.registerUser(user);
        model.addAttribute("message", message);

        log.info("REGISTER", message.getContent());

//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setFrom("tamvv3");
//        mailMessage.setTo(user.getEmail());
//        mailMessage.setSubject("LOL");
//        mailMessage.setText("Con me may nha!");
//
//        javaMailSender.send(mailMessage);

        return PAGE;
    }
}
