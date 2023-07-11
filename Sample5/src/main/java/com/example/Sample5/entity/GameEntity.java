package com.example.Sample5.entity;

import com.example.Sample5.bean.GameBean;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name="game")
@Getter
@Setter
@ToString
public class GameEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer num;
    private String title;
    private Integer price;
    private String lang; //select
    private String genre; //checkbox
    @Column(nullable = false)
    private String platform; //radio


    private static ModelMapper modelMapper = new ModelMapper();
    public static GameEntity insertGame(GameBean gameBean) {
        return modelMapper.map(gameBean, GameEntity.class);
    }
}
