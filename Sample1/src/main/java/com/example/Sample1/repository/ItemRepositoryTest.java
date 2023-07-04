package com.example.Sample1.repository;

import com.example.Sample1.ItemSellStatus;
import com.example.Sample1.entity.Item;
import com.example.Sample1.entity.QItem;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.example.Sample1.entity.QItem.item;

@SpringBootTest
public class ItemRepositoryTest {
    //쿼리 메서드
    // 1. 10번 레코드 삽입
    // 2. 모든 상품 조회
    // 3. 오렌지 상품 조회
    // 4. 가격이 300보다 작은 레코드 가격 내림차순 조회

    //쿼리 어노테이션
    // 1. 모든 상품 조회
    // 2. 상품 상세 설명에 '어' 포함 레코드 조회

    //쿼리 dsl
    // 1. 판매 중인 상품이면서,
    // 상품 상세설명에 '어' 포함된 레코드를 가격 내림차순 조회

    @Autowired
    ItemRepository itemRepository;

    //쿼리 메서드 연습
    @Test
    @DisplayName("10번 레코드 삽입")
    public void tenTimesInsert(){
        for(int i = 1; i<=10;i++){
            String[] fruit = {"사과", "배", "오렌지"};
            String[] description = {"달아요", "맛있어요", "맛없어요", "떫어요"};
            int[] stock = {100, 200, 300, 400};
            int[] price = {111, 222, 333, 444, 555};
            ItemSellStatus[] sellstatus = {ItemSellStatus.SELL,ItemSellStatus.SOLD_OUT};

            Item item = new Item();
            item.setItemNm(fruit[i%fruit.length]);
            item.setItemDetail(description[i%description.length]);
            item.setPrice(price[i%price.length]);
            item.setItemSellStatus(sellstatus[i%sellstatus.length]);
            Item ientity = itemRepository.save(item);
            System.out.println("ientity : "+ientity);
        }//for
    }//tenTimesInsert

    @Test
    @DisplayName("모든 상품 조회")
    public void findAllProduct(){
        List<Item> ilists = itemRepository.findAll();
        for(Item item : ilists){
            System.out.println(item);
        }//for
    }//findAllProduct

    @Test
    @DisplayName("오렌지 상품 조회")
    public void findOrange(){
        List<Item> olists = itemRepository.findByItemNm("오렌지");
        for(Item item : olists){
            System.out.println("오렌지 상품 : "+item);
        }//for
    }//findOrange

    @Test
    @DisplayName("가격이 300보다 작은 레코드 가격 내림차순")
    public void findLessThan300desc(){
        List<Item> ilists = itemRepository.findByPriceLessThanOrderByPriceDesc(300);
        for(Item item : ilists){
            System.out.println(item);
        }//for
    }//findLessThan300desc

    @Test
    @DisplayName("anno 모든 상품 조회")
    public void annoFindAll(){
        List<Item> ilists = itemRepository.annoFindAll();
        for(Item item : ilists){
            System.out.println(item);
        }//for
    }//annoFindAll

    @Test
    @DisplayName("상세설명 어 포함")
    public void annoFindDetail(){
        List<Item> ilists = itemRepository.annoFindDetail("어");
        for(Item item : ilists){
            System.out.println(item);
        }//for
    }//annoFindDetail

    @PersistenceContext
    EntityManager em;
    @Test
    @DisplayName("판매중, 상세설명 어 포함, 가격 내림차순")
    public void dslFindProduct(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QItem qItem = item;
        JPAQuery<Item> query = queryFactory.selectFrom(item)
                .where(qItem.itemDetail.like("%"+"어"+"%"))
                .where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
                .orderBy(qItem.price.desc());
        List<Item> ilists = query.fetch();
        for(Item item : ilists){
            System.out.println(item);
        }//for
    }
}
