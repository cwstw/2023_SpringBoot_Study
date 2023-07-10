package com.example.Sample4.repository;

import com.example.Sample4.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByOrderByNoDesc();

    Book findByNo(Integer no);
}