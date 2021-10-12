package ru.netology.Hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.Hibernate.repository.Persons;
import ru.netology.Hibernate.service.PersonsService;

import java.util.List;

@RestController
public class PersonsController {

    private final PersonsService personsService;

    public PersonsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city){
        return personsService.getPersonsByCity(city);
    }

    @GetMapping("/persons/init")
    public String initPersons() {
        return personsService.initPersons();
    }
}
