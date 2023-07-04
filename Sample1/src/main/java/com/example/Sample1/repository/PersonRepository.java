package com.example.Sample1.repository;

import com.example.Sample1.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//JpaRepository<PersonEntity, Long> : <엔티티이름, 기본키 타임>
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    List<PersonEntity> findById(String id);

    List<PersonEntity> findBySalGreaterThanOrderByNoDesc(Integer sal);


    //JPQL( Java Persistence Query Language )
    //원래 쿼리문 : select * from person p where p.name like '%아%'
    @Query( nativeQuery = false,
            value="select p from person p where p.name like %:name% order by p.no asc")

    List<PersonEntity> findByName(@Param("name") String name);

    @Query(nativeQuery = false,
            value = "select count(p.name) from person p where p.name like %:name% order by p.no asc")
    int findByNameCount(@Param("name") String name);
}
