package com.spring.app.controller.user;

import com.spring.app.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController extends AbstractController {
    private static final String PAGE = WEB + "index";

    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView(PAGE);

        List<String> names = List.of("1", "2", "3", "4");
        modelAndView.addObject("names", names);

        return modelAndView;
    }

}
