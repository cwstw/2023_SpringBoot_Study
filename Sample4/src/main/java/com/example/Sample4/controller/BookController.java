package com.example.Sample4.controller;

import com.example.Sample4.bean.BookBean;
import com.example.Sample4.entity.Book;
import com.example.Sample4.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    }

    @GetMapping(value = "/book/insert")
    public String insertBook(Model model){
        model.addAttribute("bookBean",new BookBean());
        return "/book/insert";
    }

    @PostMapping(value = "book/insert")
    public String insertPS(@Valid BookBean bookBean, BindingResult bindingResult
            , Model model){

        String result = "redirect:/";
        if (bindingResult.hasErrors()) {
            model.addAttribute("bookBean",bookBean);
            return  "/book/insert";
        }

        Book book=Book.insertBook(bookBean);
        bookService.saveBook(book);
        return result;
    }

    @GetMapping(value = "/book/detail")
    public String detailBook(Model model, @RequestParam("no") int no){
        //Book book = bookService.findByNo(no);
        Book book = bookService.findByNo(no);
        model.addAttribute("book",book);
        return "/book/detail";
    }

    @GetMapping(value = "/book/update/{no}")
    public String updateGet(@PathVariable("no") int no, Model model){
        System.out.println("no:"+no);
        Book book = bookService.findByNo(no);
        System.out.println(book.getTitle());

        String[] kind = {"유료","무료"};
        String[] bookstore = {"교보문고","알라딘","yes24","인터파크"};
        model.addAttribute("bookBean",book);
        model.addAttribute("kind",kind);
        model.addAttribute("bookstore",bookstore);
        return "book/update";
    }

    @PostMapping(value="/book/update")
    public String updatePost(@Valid BookBean bookBean, BindingResult bindingResult, Model model){

        String[] kind = {"유료","무료"};
        String[] bookstore = {"교보문고","알라딘","yes24","인터파크"};
        model.addAttribute("kind",kind);
        model.addAttribute("bookstore",bookstore);

        if(bindingResult.hasErrors()){

            model.addAttribute("bookBean",bookBean);
            return "/book/update";
        }

        Book book = Book.insertBook(bookBean);
        bookService.saveBook(book);

        return "redirect:/";
    }//updatePost

    @GetMapping("/book/delete")
    public String deleteBook(
            @PathVariable("no") int no
    ){
        bookService.deleteByNum(no);
        return "redirect:/";
    }//deleteBook
}