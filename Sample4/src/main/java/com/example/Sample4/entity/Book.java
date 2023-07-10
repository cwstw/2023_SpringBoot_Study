package com.example.Sample4.entity;
import com.example.Sample4.bean.BookBean;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@Table(name="book")
@Setter
@Getter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int no; // primary key
    private String title;
    private String author;
    private String publisher;
    private Integer price;
    private String buy;
    private String kind;
    private String bookstore;
    private Integer count;

    private static ModelMapper modelMapper = new ModelMapper();

    public static Book insertBook(BookBean bookBean) {
        //bookBean을 entity타입으로 변환
        return modelMapper.map(bookBean,Book.class);
    }

    public static Book updateBook(BookBean bookBean) {
        return modelMapper.map(bookBean,Book.class);
    }
}