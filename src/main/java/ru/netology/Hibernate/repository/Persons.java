package ru.netology.Hibernate.repository;


import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Persons implements Serializable {

    @EmbeddedId
    private PersonsKey personsKey;

    private String phone_number;
    private String city_of_living;

}
