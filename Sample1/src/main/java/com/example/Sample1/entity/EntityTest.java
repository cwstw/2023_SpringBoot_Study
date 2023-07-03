package com.example.Sample1.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@ToString
@Table(name="etest")
public class EntityTest { // entity_test 생성
    @Id
    private int num;

    @Column(name="irum", nullable = false)
    private String name;
    private String addr;
    private int age;


}
/*
 create table entity_test (
       num number(10,0) not null,
        addr varchar2(255 char),
        age number(10,0) not null,
        name varchar2(255 char),
        primary key (num)
    )
*/