package com.mysite.sbb.controller;

import com.mysite.sbb.entity.Question;
import com.mysite.sbb.entity.SiteUser;
import com.mysite.sbb.form.AnswerForm;
import com.mysite.sbb.form.QuestionForm;
import com.mysite.sbb.service.QuestionService;
import com.mysite.sbb.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;

    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam(value="page", defaultValue = "0") int page) {
        Page<Question> paging = this.questionService.getList(page);

        //1부터 시작하도록
        int nowPage = paging.getPageable().getPageNumber()+1;
        int startPage = Math.max(nowPage-4,1);
        int endPage = Math.min(nowPage+5,paging.getTotalPages());

        model.addAttribute("paging",paging);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id,
                         AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question",question);
        return "question_detail";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm){
        return "question_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm,
                                 BindingResult result,
                                 Principal principal){
        if(result.hasErrors())
            return "question_form";
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(),questionForm.getContent(), siteUser);
        return "redirect:/question/list";
    }


}
