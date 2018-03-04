package com.example.controller;

import com.example.command.PersonCommand;

public abstract class PersonControllerCommon {

    protected PersonCommand createPersonComand(String id) {
        PersonCommand personCommand = new PersonCommand();
        personCommand.setId(id);
        personCommand.setName("Pepe");
        personCommand.setSurname("Garcia");

        return personCommand;
    }

    protected PersonCommand createPersonComand(PersonCommand personCommand) {
        personCommand.setName("Pepe");
        personCommand.setSurname("Garcia");

        return personCommand;
    }

}
