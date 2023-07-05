package com.example.Sample3.bean;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MovieBean {
    private Integer num;
    @NotBlank(message="아이디는 필수 입력입니다.")
    private String id;
    @NotBlank(message="이름은 필수 입력입니다.")
    private String name;
    @NotBlank(message="나이는 필수 입력입니다.")
    private Integer age;
    @NotEmpty(message="장르는 최소 한 개 선택해야 합니다.")
    private String genre; //checkbox
    private String time; //select-option
    @NotBlank(message = "동반 관객수는 필수 입력입니다.")
    private Integer partner; //radio
    private String memo;
}
