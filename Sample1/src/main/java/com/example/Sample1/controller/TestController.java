package com.example.Sample1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    //test 요청
    @GetMapping("test")
    public String test(){
        return "test";
    }
}
