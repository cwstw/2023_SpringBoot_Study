package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/sbb")
    @ResponseBody
    public String index(){
        //System.out.println("index");
        return "sbb 요청 리턴";
    }

    @GetMapping("/")
    public String root(){
        return "redirect:/question/list";
    }
}