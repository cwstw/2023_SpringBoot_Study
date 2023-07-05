package com.example.Sample2.controller;

import com.example.Sample2.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @GetMapping(value="/ex01")
    public String Exam01(Model model){
        model.addAttribute("data","타임리프 1번 예제입니다.");
        model.addAttribute("name","김세월");
        return "viewEx01"; //기본 위치 templates
    }//exam01

    @GetMapping(value="/ex02")
    public String Exam02(Model model){
        ItemDto itemDto = new ItemDto();
        itemDto.setId(1L);
        itemDto.setItemNm("상품");
        itemDto.setPrice(300);
        itemDto.setItemDetail("상품설명입니다.");
        itemDto.setRegTime(LocalDateTime.now()); //현재시간

        model.addAttribute("itemDto",itemDto);

        return "viewEx02";
    }//Exam02

    @GetMapping(value="/ex03")
    public String Exam03(Model model){
        List<ItemDto> itmeDtoList = new ArrayList<>();
        for(Long i=1L;i<=10;i++){
            ItemDto itemDto = new ItemDto();
            itemDto.setId(i);
            itemDto.setItemNm("상품"+i);
            itemDto.setPrice(300);
            itemDto.setItemDetail(i+"상품설명입니다.");
            itemDto.setRegTime(LocalDateTime.now());
            itmeDtoList.add(itemDto);
        }//for
        model.addAttribute("itemDtoList",itmeDtoList);
        return "viewEx03";
    }//Exam03

    @GetMapping(value="/ex04")
    public String Exam04(Model model){
        List<ItemDto> itmeDtoList = new ArrayList<>();
        for(Long i=1L;i<=10;i++){
            ItemDto itemDto = new ItemDto();
            itemDto.setId(i);
            itemDto.setItemNm("상품"+i);
            itemDto.setPrice(300);
            itemDto.setItemDetail(i+"상품설명입니다.");
            itemDto.setRegTime(LocalDateTime.now());
            itmeDtoList.add(itemDto);
        }//for
        model.addAttribute("itemDtoList",itmeDtoList);
        return "thymeleaf/viewEx04";
    }//Exam04

    @GetMapping(value="/ex05")
    public String Exam05(Model model){
        List<ItemDto> itmeDtoList = new ArrayList<>();
        for(int i=1;i<=10;i++){
            ItemDto itemDto = new ItemDto();
            itemDto.setItemNm("상품"+i);
            itemDto.setPrice(300*i);
            itemDto.setItemDetail(i+"상품설명입니다.");
            itemDto.setRegTime(LocalDateTime.now());
            itmeDtoList.add(itemDto);
        }//for
        model.addAttribute("itemDtoList",itmeDtoList);
        return "thymeleaf/viewEx05";
    }//Exam05
    @GetMapping(value="/ex06")
    public String Exam06(){
         return "thymeleaf/viewEx06";
    }//Exam05
}
