package ru.netology.Hibernate.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Repository
public class PersonsRepository {

    private PersonsJpaRepository personsJpaRepository;

    public PersonsRepository(PersonsJpaRepository personsJpaRepository) {
        this.personsJpaRepository = personsJpaRepository;
    }
    @Transactional
    public void initPersons() {
        List<String> names = List.of("Andrey", "Pavel", "Vlad");
        List<String> surNames = List.of("Petrov", "Ivanov", "Sidorov");
        List<String> cites = List.of("Moscow", "London", "New York");

        Random random = new Random();
        IntStream.range(0, 10)
                .forEach(i -> {
                    var personsKey = PersonsKey.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surNames.get(random.nextInt(surNames.size())))
                            .age(random.nextInt(100))
                            .build();
                    var person = Persons.builder()
                            .personsKey(personsKey)
                            .phone_number("Телефон")
                            .city(cites.get(random.nextInt(cites.size())))
                            .build();
                    personsJpaRepository.save(person);
                });
    }
    public List<Persons> getPersonsByCity(String city) {
        return personsJpaRepository.findByCity(city);
    }

    public List<Persons> getPersonsLessAge(int age) {
        return personsJpaRepository.findByPersonsKey_AgeLessThanOrderByPersonsKeyAge(age);
    }

    public List<Persons> getPersonsNameSurname(String name, String surname) {
        return personsJpaRepository.findFirstByPersonsKey_NameAndPersonsKey_Surname(name, surname);
    }

}
