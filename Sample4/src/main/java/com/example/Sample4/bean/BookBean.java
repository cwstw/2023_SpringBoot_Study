package com.example.Sample4.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookBean {

    private Integer num;
    @NotBlank(message="제목은 필수 입력입니다.")
    private String title;
    @NotBlank(message="저자는 필수 입력입니다.")
    private String author;
    @NotBlank(message="출판사는 필수 입력입니다.")
    private String publisher;
    @NotNull(message="가격은 필수 입력입니다.")
    private Integer price;
    @NotBlank(message="입고일은 필수 입력입니다.")
    private  String buy;
    @NotNull(message="배송비는 필수 입력입니다.")
    private String kind; //radio
    @NotEmpty(message="구입가능 서점은 필수 입력입니다.")
    private String bookstore; //checkbox
    @NotNull(message="보유 수량은 필수 입력입니다.")
    private Integer count; //select
}
