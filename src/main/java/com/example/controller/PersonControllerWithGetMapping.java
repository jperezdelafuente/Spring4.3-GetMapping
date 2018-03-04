package com.example.controller;

import com.example.command.PersonCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class PersonControllerWithGetMapping extends PersonControllerCommon {

    // Invoke: http://localhost:8080/personGetMapping?name=Pepe&surname=Garcia
    // Without using @RequestParam
    @GetMapping("/personGetMapping")
    public String getPersonGetMapping(PersonCommand personCommand, Model model){
        log.info("Name: {}", personCommand.getName());
        log.info("Surname: {}", personCommand.getSurname());

        model.addAttribute("person", personCommand);

        return "person-view";
    }

    // Invoke: http://localhost:8080/personGetMappingById?id=1
    // Without using @RequestParam
    @GetMapping("/personGetMappingById")
    public String getPersonGetMappingById(String id, Model model){
        log.info("Id: {}", id);

        PersonCommand personCommand = this.createPersonComand(id);

        model.addAttribute("person", personCommand);

        return "person-view";
    }

    // Invoke: http://localhost:8080/personGetMappingPath/1
    @GetMapping("/personGetMappingPath/{id}")
    public String getPersonGetMappingPath(@PathVariable("id") String id, Model model){
        log.info("Id: {}", id);

        PersonCommand personCommand = this.createPersonComand(id);

        model.addAttribute("person", personCommand);

        return "person-view";
    }

    // Invoke: http://localhost:8080/personGetMappingPathWithModelAttribute/1
    @GetMapping("/personGetMappingPathWithModelAttribute/{id}")
    public String getPersonGetMappingPathWithModelAttribute(@ModelAttribute PersonCommand personCommand, Model model){
        log.info("Id: {}", personCommand.getId());

        personCommand = this.createPersonComand(personCommand);

        model.addAttribute("person", personCommand);

        return "person-view";
    }

}
