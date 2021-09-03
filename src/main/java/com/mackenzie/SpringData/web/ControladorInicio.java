package com.mackenzie.SpringData.web;

import com.mackenzie.SpringData.domain.Persona;
import com.mackenzie.SpringData.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
@Slf4j
public class ControladorInicio {

    private Iterable<Persona> personas;

    // Esta anotacion equivale a @Inject para la Injeccion de dependencias
    @Autowired
    private PersonaService service;



    @GetMapping("/")
    public String inicio(Model model) {
        // Con inferencia de tipos
        // var personas = personaDao.findAll();
        // Sin inferencia de tipos
        personas = service.getAllPersonas();

        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        // log.debug("Mas destalles del controlador spring en puerto 9090");
        return "index";

    }

}
