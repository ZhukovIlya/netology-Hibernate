package ru.netology.Hibernate.repository;


import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Embeddable
public class PersonsKey implements Serializable {

    private String name;

    private String surname;

    private int age;
}
