package com.mysite.sbb.service;

import com.mysite.sbb.entity.Answer;
import com.mysite.sbb.entity.Question;
import com.mysite.sbb.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Question question, String content){
        Answer answer = new Answer();
        answer.setContent(content);//답변
        answer.setCreateDate(LocalDateTime.now());//시간
        answer.setQuestion(question);//질문
        this.answerRepository.save(answer);//답변 정보 저장
    }
}
