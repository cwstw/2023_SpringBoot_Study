package com.example.Sample1.repository;

import com.example.Sample1.entity.EntityTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EntityRepositoryTest {

    @Autowired
    EntityRepository entityRepository;

    @Test
    @DisplayName("entity 저장 테스트")
    public void entitySave(){
        //insert 기능을 수행
        EntityTest etest = new EntityTest();
        etest.setNum(12);
        etest.setName("박세리");
        etest.setAge(40);
        etest.setAddr("부산");

        entityRepository.save(etest);
    }

    @Test
    @DisplayName("모든 레코드 조회 테스트")
    public void findAllTest(){
        //모든 레코드의 내용을 저장
        List<EntityTest> elists =  entityRepository.findAll();
        for(EntityTest etest:elists){
            System.out.println(etest);
        }
    }

    @Test
    @DisplayName("특정 레코드 조회")
    public void findName(){
        //박세리라는 내용의 이름 행을 반복해서 저장
        List<EntityTest> elists = entityRepository.findByName("박세리");
        for(EntityTest etest:elists){
            System.out.println(etest);
        }
    }

    @Test
    @DisplayName("조건 나이 조회")
    public void findAge(){
        //30이상, 30이하의 나이 속성을 가진 행 저장
        //List<EntityTest> elists = entityRepository.findByAgeLessThan(30); //30보다 작은
        List<EntityTest> elists = entityRepository.findByAgeGreaterThan(30); //30보다 큰
        for(EntityTest etest:elists){
            System.out.println(etest);
        }
    }
}


