package com.mackenzie.SpringData.web;

import com.mackenzie.SpringData.domain.Persona;
import com.mackenzie.SpringData.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {

    private List<Persona> personas;


    // Esta anotacion equivale a @Inject para la Injeccion de dependencias
    @Autowired
    private PersonaService service;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        // Con inferencia de tipos
        // var personas = personaDao.findAll();
        // Sin inferencia de tipos
        personas = service.getAllPersonas();

        log.info("ejecutando el controlador Spring MVC");
        log.info("Alguien se logee con exito: " + user);
        model.addAttribute("personas", personas);
        var saldoTotal = 0D;
        for (var p: personas) {
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        // log.debug("Mas destalles del controlador spring en puerto 9090");
        return "index";

    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "edit";
    }

    @PostMapping("/guardar")
    public String save(@Valid Persona persona, Errors err) {
        if (err.hasErrors()) {
            return "edit";
        }
        service.save(persona);
        return "redirect:/";
    }

    @GetMapping("/edit/{idPersona}")
    public String edit(Persona persona, Model model) {
        persona = service.findPersona(persona);
        model.addAttribute("persona", persona);
        return "edit";
    }

    @GetMapping("/delete")
    public String delete(Persona persona) {
        service.delete(persona);
        return "redirect:/";
    }

}
