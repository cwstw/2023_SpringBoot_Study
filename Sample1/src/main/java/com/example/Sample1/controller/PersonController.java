package com.example.Sample1.controller;

import com.example.Sample1.bean.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("person")
    public Person test(){
    Person p1 = new Person();
    p1.setId("1");
    p1.setName("유재석");
    p1.setAddr("서울");
    p1.setSal(300);
    return p1;
    }

}
