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

    public List<Persons> getPersonsByCity(String city_of_living) {
        return personsRepository.getPersonsByCity(city_of_living);
    }

    public String initPersons() {
        personsRepository.initPersons();
        return "Ok";
    }
}
