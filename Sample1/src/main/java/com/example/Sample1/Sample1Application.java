package com.example.Sample1;

import com.example.Sample1.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sample1Application {

	public static void main(String[] args) {
		SpringApplication.run(Sample1Application.class, args);
/*
		Employee e1 = new Employee();

		//setter를 통한 주입
		e1.setId("kim");
		e1.setName("김연아");
		e1.setAge(30);
		
		System.out.println("id : "+e1.getId());
		System.out.println("name : "+e1.getName());
		System.out.println("age : "+e1.getAge());
		System.out.println("e1 : "+e1);//뒤에 toString() 생략
		System.out.println("==========================");
		
		//constructor를 통한 주입
		Employee e2 = new Employee("son", "손흥민", 30);
		System.out.println("id : "+e2.getId());
		System.out.println("name : "+e2.getName());
		System.out.println("age : "+e2.getAge());
		System.out.println("e1 : "+e2);*/

		Person p1 = new Person();
		Person p2 = new Person("1","유재석","서울",300);

		//geter출력
		p1.setId("2");
		p1.setName("김연아");
		p1.setAddr("경기");
		p1.setSal(400);
		System.out.println("id : "+p1.getId());
		System.out.println("name : "+p1.getName());
		System.out.println("addr : "+p1.getAddr());
		System.out.println("sal : "+p1.getSal());
		System.out.println("p1 : "+p1);
		System.out.println("=======================");
		//toString출력
		System.out.println("id : "+p2.getId());
		System.out.println("name : "+p2.getName());
		System.out.println("addr : "+p2.getAddr());
		System.out.println("sal : "+p2.getSal());
		System.out.println("p2 : "+p2);

	}
}
