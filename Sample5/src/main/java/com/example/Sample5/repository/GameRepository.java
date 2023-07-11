package com.example.Sample5.repository;

import com.example.Sample5.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<GameEntity,Integer> {

    List<GameEntity> findByOrderByNumDesc(); //전체 게임 목록 + Num 내림차순


}
