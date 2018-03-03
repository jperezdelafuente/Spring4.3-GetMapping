package com.example.getmapping.controller;

import com.example.getmapping.command.PersonCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class PersonController {

    // Invoke: http://localhost:8080/person?name=Pepe&surname=Garcia
    @GetMapping("/person")
    public String getPerson(PersonCommand personCommand, Model model){

        log.info("Name: " + personCommand.getName());
        log.info("Surname: " + personCommand.getSurname());

        model.addAttribute("person", personCommand);

        return "person-view";
    }
}
