package com.example.Sample1.controller;

import com.example.Sample1.bean.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*@Controller
@ResponseBody*/
@RestController
public class EmployeeController {


    //test 요청
    @GetMapping("employee")
    public Employee test() {
        Employee e1 = new Employee();

        e1.setId("kim");
        e1.setName("김연아");
        e1.setAge(30);

        return e1;
    }
}
