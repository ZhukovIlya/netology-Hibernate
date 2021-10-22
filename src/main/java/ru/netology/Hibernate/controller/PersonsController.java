package ru.netology.Hibernate.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.Hibernate.repository.Persons;
import ru.netology.Hibernate.service.PersonsService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class PersonsController {

    private final PersonsService personsService;

    public PersonsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/persons/by-city")
    @Secured("ROLE_READ")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city) {
        return personsService.getPersonsByCity(city);
    }

    @GetMapping("/persons/less-age")
    @RolesAllowed("ROLE_WRITE")
    public List<Persons> getPersonsLessAge(@RequestParam("age") int age) {
        return personsService.getPersonsLessAge(age);
    }

    @GetMapping("/persons")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public List<Persons> getPersonsNameSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return personsService.getPersonsNameSurname(name, surname);
    }

    @GetMapping("/persons/init")
    public String initPersons() {
        return personsService.initPersons();
    }
}
