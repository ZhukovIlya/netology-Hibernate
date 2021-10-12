package ru.netology.Hibernate.service;


import org.springframework.stereotype.Service;
import ru.netology.Hibernate.repository.Persons;
import ru.netology.Hibernate.repository.PersonsRepository;

import java.util.List;

@Service
public class PersonsService {
    private final PersonsRepository personsRepository;

    public PersonsService(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    public List<Persons> getPersonsByCity(String city) {
        return personsRepository.getPersonsByCity(city);
    }

    public String initPersons() {
        personsRepository.initPersons();
        return "Ok";
    }
}
