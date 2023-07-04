package com.example.Sample1.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity(name="person")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="person")
@SequenceGenerator(name = "person_seq",
                sequenceName = "person_seq_name",
                initialValue = 1,
                allocationSize = 1)
public class PersonEntity { //person_entity => person으로 테이블명 저장
    //generator = "person_seq"이 없어도 생성은 가능
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    private Long no;
    private String id;
    private String name;
    @Column(name="address")
    private String addr;
    private Integer sal;
}
