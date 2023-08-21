package com.mysite.sbb.controller;

import com.mysite.sbb.entity.Question;
import com.mysite.sbb.form.AnswerForm;
import com.mysite.sbb.service.AnswerService;
import com.mysite.sbb.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(
            Model model,
            @PathVariable("id") Integer id,
            @Valid AnswerForm answerForm, BindingResult result){
        Question question = this.questionService.getQuestion(id);
        if(result.hasErrors()){
            model.addAttribute("question",question);
            return "question_detail";
        }
        this.answerService.create(question,answerForm.getContent());
        return String.format("redirect:/question/detail/%s",id);
    }

}
