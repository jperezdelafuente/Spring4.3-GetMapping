package com.example.getmapping.controller;

import com.example.getmapping.command.PersonCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class PersonController {

    // Invoke: http://localhost:8080/personGetMapping?name=Pepe&surname=Garcia
    @GetMapping("/personGetMapping")
    public String getPersonGetMapping(PersonCommand personCommand, Model model){

        log.info("Name: " + personCommand.getName());
        log.info("Surname: " + personCommand.getSurname());

        model.addAttribute("person", personCommand);

        return "person-view";
    }

    // Invoke: http://localhost:8080/personRequestMapping?name=Pepe&surname=Garcia
    @RequestMapping(value = "/personRequestMapping", method = RequestMethod.GET)
    public String getPersonRequestMapping(PersonCommand personCommand, Model model){

        log.info("Name: " + personCommand.getName());
        log.info("Surname: " + personCommand.getSurname());

        model.addAttribute("person", personCommand);

        return "person-view";
    }

}
