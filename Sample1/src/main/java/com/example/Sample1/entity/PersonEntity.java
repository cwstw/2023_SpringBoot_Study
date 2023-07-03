package com.example.Sample1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="person")
@SequenceGenerator(name = "person_seq",
                sequenceName = "person_seq_name",
                initialValue = 1,
                allocationSize = 1)
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    private Long no;
    private String id;
    private String name;
    @Column(name="address")
    private String addr;
    private Integer sal;
}
