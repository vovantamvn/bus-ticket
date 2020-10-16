package com.spring.app.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView("web/index");
        return modelAndView;
    }

}
