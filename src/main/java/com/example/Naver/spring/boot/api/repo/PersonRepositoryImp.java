package com.example.naver.spring.boot.api.repo;

import com.example.naver.spring.boot.api.domain.model.Person;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepositoryImp implements PersonRepository {

    private List<Person> people;

    @Override
    public List<Person> getPeople() {
        return people;
    }

    @Override
    public Person findPerson(String id) {
        Optional<Person> result = people.stream()
                .filter(p -> p.getId().toString().equals(id))
                .findFirst();
        return result.orElse(null);
    }

    // This function just use for demo purpose
    @PostConstruct
    public void initStaticList() {
        people = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Person person = new Person("Trung Hieu " + i, 20 + i, "Hobby " + i);
            people.add(person);
            System.out.println(person);
        }
    }

}
