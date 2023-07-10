package com.example.Sample4.controller;

import com.example.Sample4.bean.BookBean;
import com.example.Sample4.entity.Book;
import com.example.Sample4.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping(value = {"/", "books"})
    public String getAllBooks(Model model){
        List<Book> bookList = bookService.findByOrderByNoDesc();
        model.addAttribute("bookList", bookList);
        return "/book/select";
    }//getAllBooks

    @GetMapping(value = "/book/insert")
    public String insertBook(Model model){
        model.addAttribute("bookBean",new BookBean());
        return "/book/insert";
    }//insertBook
    @PostMapping(value = "/book/insert")
    public String insertBook(@Valid BookBean bookBean, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("bookBean",bookBean);
            return "/book/insert";
        }
        //Entity 타입으로 변환한 bookBean을 반환
        Book book = Book.insertBook(bookBean);
        bookService.saveBook(book);

        return "redirect:/";
    }//insertBook

    @GetMapping(value = "/book/detail")
    public String detail(
            @RequestParam Integer no,
            Model model){
        Book book = bookService.findByNo(no);
        model.addAttribute("book",book);
        return "/book/detail";
    }//detail

    @GetMapping(value = "/book/update")
    public String updateBook(
            @RequestParam Integer no,
            Model model){
        Book book = bookService.findByNo(no);
        model.addAttribute("book",book);
        return "/book/update";
    }//updateBook

    @PostMapping(value = "/book/update")
    public String updateBook(@Valid BookBean bookBean, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("bookBean",bookBean);
            return "/book/update";
        }
        //Entity 타입으로 변환한 bookBean을 반환
        Book book = Book.updateBook(bookBean);
        bookService.saveBook(book);

        return "redirect:/";
    }//updateBook
}