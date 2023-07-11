package com.example.Sample5.service;

import com.example.Sample5.entity.GameEntity;
import com.example.Sample5.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public List<GameEntity> findByOrderByNumDesc() {
        List<GameEntity> games = gameRepository.findByOrderByNumDesc();
        return games;
    }//findByOrderByNumDesc()


    public void saveGame(GameEntity game) {
        gameRepository.save(game);
    }//saveGame

    public GameEntity findByNum(int num) {
        GameEntity game = gameRepository.findById(num).orElseThrow();
        return game;
    }//findByNum


    public void deleteGame(int num) {
        gameRepository.deleteById(num);
    }
}
