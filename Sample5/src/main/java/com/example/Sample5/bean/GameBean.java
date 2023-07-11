package com.example.Sample5.bean;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameBean {
    private final String same = "은(는) 필수 입력입니다.";

    private Integer num;
    @NotEmpty(message = "타이틀"+same)
    private String title;
    @NotNull(message = "가격"+same)
    private Integer price;
    @NotEmpty(message = "언어"+same)
    private String lang; //select
    @NotEmpty(message = "장르"+same)
    private String genre; //checkbox
    @NotNull(message = "플랫폼"+same)
    private String platform; //radio
}
