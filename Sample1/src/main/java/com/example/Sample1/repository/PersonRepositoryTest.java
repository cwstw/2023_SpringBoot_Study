package com.example.Sample1.repository;

import com.example.Sample1.entity.EntityTest;
import com.example.Sample1.entity.PersonEntity;
import com.example.Sample1.entity.QPersonEntity;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.example.Sample1.entity.QPersonEntity.personEntity;

@SpringBootTest
public class PersonRepositoryTest {
    //1,kim,김연아,서울,3000

    @Autowired
    PersonRepository personRepository;

    @Test
    @DisplayName("insert 수행")
    public void insertData(){
        //생성자 통한 주입
        PersonEntity person = new PersonEntity(1L,"kim","김연아","서울",3000);
        /*setter통한 주입
        person.setNo(1L);
        person.setId("kim");
        person.setName("김연아");
        person.setAddr("서울");
        person.setSal(3000);*/
        personRepository.save(person);
    }

    @Test
    @DisplayName("person Many Save Test")
    public void PersonMaySave(){
        String[] id = {"jung","choi","hong"};
        String[] addr = {"제주","부산","경기","경주"};
        String[] name= {"아이유","윤아","보검","현빈"};
        int[] sal = {2000,3500,2700,4200};
        for(int i = 1; i<=10;i++){
            PersonEntity person = new PersonEntity();
            //id[1%3 = 1], id[2%3 = 2], id[3%3 = 0], id[4%3 = 1]
            //120120...반복
            person.setId(id[i%id.length]);
            person.setName(name[i%name.length]);
            person.setAddr(addr[i%addr.length]);
            person.setSal(sal[i%sal.length]);
            PersonEntity pentity = personRepository.save(person);
            System.out.println("pentity : "+pentity);
        }//for
    }//PersonManySave

    @Test
    @DisplayName("id가 jung인 레코드 조회, 출력")
    public void findId(){
        List<PersonEntity> plists = personRepository.findById("jung");
        for(PersonEntity ptest : plists)
            System.out.println(ptest);
    }//findId

    @Test
    @DisplayName("모든 레코드 조회 테스트")
    public void findAllPerson(){
        //모든 레코드의 내용을 저장
        List<PersonEntity> plists =  personRepository.findAll();
        for(PersonEntity ptest:plists) {
            System.out.println(ptest);
        }//for
    }//findAllPerson

    @Test
    @DisplayName("조건 급여 조회")
    public void findSal(){
        List<PersonEntity> plists = personRepository.findBySalGreaterThanOrderByNoDesc(3000);
        for(PersonEntity ptest:plists){
            System.out.println(ptest);
        }//for
    }//findSal

    @Test
    @DisplayName("이름에 아 포함된 레코드 조회")
    public void findByName(){
        List<PersonEntity> plists = personRepository.findByName("아");
        for(PersonEntity ptest:plists){
            System.out.println(ptest);
        }//for
    }//findByName


    @Test
    @DisplayName("이름에 아 포함된 레코드 갯수")
    public void findByNameCount(){
        int pcount= personRepository.findByNameCount("아");
        System.out.println(pcount);
    }//findByNameCount

    //해당 객체 주입
    @PersistenceContext
    EntityManager em;
    //쿼리 DSL ()
    @Test
    @DisplayName("query dsl")
    public void queryDslTest(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QPersonEntity qPerson = personEntity;
        //personEntity에 설정한 테이블을 사용하겠다는 의미
        //"아"가 포함된 3000보다 적은 레코드를 id기준 내림차순 정렬
        JPAQuery<PersonEntity> query = queryFactory
                                        .selectFrom(qPerson)
                                        .where(qPerson.name.like("%"+"아"+"%"))
                                        .where(qPerson.sal.lt(3000))
                                        .orderBy(qPerson.id.desc());

        List<PersonEntity> plists = query.fetch();
        for(PersonEntity p : plists){
            System.out.println(p);
        }//for
    }//queryDslTest

}
