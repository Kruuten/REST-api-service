package ru.kruten.rest_api_test1_cft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class SwaggerController {
    @RequestMapping("/swagger")
    public String toSwagger(){
        return "redirect:/swagger-ui.html";
    }
}
