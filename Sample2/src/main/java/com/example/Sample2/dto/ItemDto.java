package com.example.Sample2.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Long id;
    private String itemNm;
    private Integer price;
    private String itemDetail;
    private LocalDateTime regTime;

    public String getItemNm(){
        System.out.println("getItemNm()");
        return itemNm;
    }

}
