package com.example.naver.spring.boot.api.service;

import com.example.naver.spring.boot.api.domain.model.Person;
import com.example.naver.spring.boot.api.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person findPerson(String id) {
        return personRepository.findPerson(id);
    }

    public List<Person> getPeopleSortedByAge() {
        return personRepository.getPeople()
                .stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .collect(Collectors.toList());
    }
}
