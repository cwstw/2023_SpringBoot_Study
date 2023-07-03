package com.example.Sample1.bean;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String id;
    private String name;
    private Integer age;

    //기본 생성자
/*    public Employee(){
    }*/
    
    //매개변수 생성자
/*    public Employee(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }*/

    public void setId(String id){
        this.id = "park";
    }
    public String getId(){
        return id;
    }

}
