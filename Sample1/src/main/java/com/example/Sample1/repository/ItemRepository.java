package com.example.Sample1.repository;

import com.example.Sample1.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemNm(String itemNm);

    List<Item> findByPriceLessThanOrderByPriceDesc(int price);

    @Query(value="select i from item i")
    List<Item> annoFindAll();

    @Query(value="select i from item i where i.itemDetail like %:detail%")
    List<Item> annoFindDetail(@Param("detail") String detail);
}
