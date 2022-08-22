package com.example.naver.spring.boot.api.repo;

import com.example.naver.spring.boot.api.domain.model.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> getPeople();

    Person findPerson(String id);

}
