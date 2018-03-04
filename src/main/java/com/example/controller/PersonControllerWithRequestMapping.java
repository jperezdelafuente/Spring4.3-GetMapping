package com.example.controller;

import com.example.command.PersonCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class PersonControllerWithRequestMapping extends PersonControllerCommon {

    // Invoke: http://localhost:8080/personRequestMapping?name=Pepe&surname=Garcia
    // Without using @RequestParam
    @RequestMapping(value = "/personRequestMapping", method = RequestMethod.GET)
    public String getPersonRequestMapping(PersonCommand personCommand, Model model){
        log.info("Name: {}", personCommand.getName());
        log.info("Surname: {}", personCommand.getSurname());

        model.addAttribute("person", personCommand);

        return "person-view";
    }

    // Invoke: http://localhost:8080/personRequestMappingById?id=1
    // Without using @RequestParam
    @RequestMapping(value = "/personRequestMappingById", method = RequestMethod.GET)
    public String getPersonRequestMappingById(String id, Model model){
        log.info("Id: {}", id);

        PersonCommand personCommand = this.createPersonComand(id);

        model.addAttribute("person", personCommand);

        return "person-view";
    }

    // Invoke: http://localhost:8080/personRequestMappingPath/1
    @RequestMapping(value = "/personRequestMappingPath/{id}", method = RequestMethod.GET)
    public String getPersonRequestMappingPath(@PathVariable("id") String id, Model model){
        log.info("Id: {}", id);

        PersonCommand personCommand = this.createPersonComand(id);

        model.addAttribute("person", personCommand);

        return "person-view";
    }

    // Invoke: http://localhost:8080/personRequestMappingPathWithModelAttribute/1
    @RequestMapping(value = "/personRequestMappingPathWithModelAttribute/{id}", method = RequestMethod.GET)
    public String getPersonRequestMappingPathWithModelAttribute(@ModelAttribute PersonCommand personCommand, Model model){
        log.info("Id: {}", personCommand.getId());

        personCommand = this.createPersonComand(personCommand);

        model.addAttribute("person", personCommand);

        return "person-view";
    }

}
