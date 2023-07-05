package com.example.Sample2.controller;

import com.example.Sample2.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    }//Exam06

    @GetMapping(value="/ex07")
    public String Exam07(){
         return "thymeleaf/viewEx07";
    }//Exam07

    @GetMapping(value="/ex08")
    public String Exam08(
            @RequestParam("param1") String param1,
            @RequestParam("param2") String param2,
            Model model){
            //만약 넘어오는 값과 변수명이 같다면 생략 가능
            //@RequestParam("param2") String param2 => String param1
            //requestparam으로 넘길 시 해당 변수에 값이 없으면 에러
                if(param1.equals(null)){
                    param1 = "하하하";
                }
                if(param2.equals(null)){
                    param2 = "호호호";
                }
                model.addAttribute("param1",param1);
                model.addAttribute("param2",param2);
         return "thymeleaf/viewEx08";
    }//Exam08

    @GetMapping(value="/ex09")
    public String Exam09(){
        return "thymeleaf/viewEx09";
    }//Exam09

    @GetMapping(value="/first")
    public String first(){
        return "thymeleaf/first";
    }//fisrt

    @GetMapping(value="/second")
    public String second(){
        return "thymeleaf/second";
    }//second

    @GetMapping(value="/third")
    public String third(){
        return "thymeleaf/third";
    }//third

}
