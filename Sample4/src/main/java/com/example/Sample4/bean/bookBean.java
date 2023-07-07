package com.example.Sample4.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class bookBean {
    private Integer num;
    private String title;
    private String author;
    private String publisher;
    private Integer price;
    private  String buy;
    private String kind;
    private String bookstore;
    private Integer count;
}
