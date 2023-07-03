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
        List<EntityTest> elists =  entityRepository.findAll();
        for(EntityTest etest:elists){
            System.out.println(etest);
        }
    }

    @Test
    @DisplayName("특정 레코드 조회")
    public void findName(){
        List<EntityTest> elists = entityRepository.findByName("박세리");
        for(EntityTest etest:elists){
            System.out.println(etest);
        }
    }

    @Test
    @DisplayName("나이 조회")
    public void findAge(){
        //List<EntityTest> elists = entityRepository.findByAgeLessThan(30); //30보다 작은
        List<EntityTest> elists = entityRepository.findByAgeGreaterThan(30); //30보다 큰
        for(EntityTest etest:elists){
            System.out.println(etest);
        }
    }
}


