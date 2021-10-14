package ru.netology.Hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonsJpaRepository extends JpaRepository<Persons, PersonsKey> {

    List<Persons> findByCity(String city);

    List<Persons> findByPersonsKey_AgeLessThanOrderByPersonsKeyAge(int PersonsKeyAge);

    List<Persons> findFirstByPersonsKey_NameAndPersonsKey_Surname(String name, String surname);
}
