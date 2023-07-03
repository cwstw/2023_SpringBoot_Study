package com.example.Sample1.repository;

import com.example.Sample1.entity.EntityTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntityRepository extends JpaRepository<EntityTest,Integer> {

    List<EntityTest> findByName(String name);
    List<EntityTest> findByAgeLessThan(Integer age);
    List<EntityTest> findByAgeGreaterThan(Integer age);
}
