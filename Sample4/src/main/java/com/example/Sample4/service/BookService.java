package com.example.Sample4.service;

import com.example.Sample4.bean.BookBean;
import com.example.Sample4.entity.Book;
import com.example.Sample4.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    @Autowired
    private final BookRepository bookRepository;


    public List<Book> findByOrderByNoDesc() {
        return bookRepository.findByOrderByNoDesc();
    }

    public void deleteByNum(int num) {
        bookRepository.deleteById(num);
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public Book findByNo(Integer no) {
        //Book book = bookRepository.findByNo(no) 혹은
        //orElseThrow() : 예외처리
        Book book = bookRepository.findById(no).orElseThrow();
        return book;
    }
}