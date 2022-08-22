package com.example.naver.spring.boot.api.controller;

import com.example.naver.spring.boot.api.domain.model.Person;
import com.example.naver.spring.boot.api.service.PersonService;
import com.example.naver.spring.boot.common.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping("/api/person/{id}")
    public ResponseEntity<BaseResponse> getPerson(@PathVariable String id) {
        Person result = personService.findPerson(id);
        if (result == null) {
            return new ResponseEntity(new BaseResponse("person not found", null), HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(new BaseResponse(null, result));
        }
    }

    @RequestMapping
    public String getPeopleTemplate(Model model) {
        model.addAttribute("people", personService.getPeopleSortedByAge());
        return "index";
    }
}
