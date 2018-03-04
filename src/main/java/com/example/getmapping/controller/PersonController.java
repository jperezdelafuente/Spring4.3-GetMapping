package com.example.getmapping.controller;

import com.example.getmapping.command.PersonCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class PersonController {

    private PersonCommand createPersonComand(String id) {
        PersonCommand personCommand = new PersonCommand();
        personCommand.setId(id);
        personCommand.setName("Pepe");
        personCommand.setSurname("Garcia");

        return personCommand;
    }

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

}
