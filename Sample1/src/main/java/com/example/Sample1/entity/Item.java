package com.example.Sample1.entity;

import com.example.Sample1.ItemSellStatus;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name="item")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 10)
    private String itemNm;
    private int price;
    private String itemDetail;
    protected ItemSellStatus itemSellStatus;

    private LocalDateTime regTime;
}
