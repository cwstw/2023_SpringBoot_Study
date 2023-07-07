package com.example.Sample3.entity;

import com.example.Sample3.bean.MovieBean;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name="movies")
@Getter
@Setter
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer num;
    private String id;
    private String name;
    private Integer age;
    private String genre; //checkbox
    private String time; //select-option
    @Column(nullable=false)
    private Integer partner; //radio
    private String memo;

    private static ModelMapper modelMapper = new ModelMapper();

    //입력한 정보가 담겨 넘어옴
    public static Movie insertMovie(MovieBean movieBean) {
        //movieBean을 entity타입으로 변환
        return modelMapper.map(movieBean,Movie.class);
    }

    public static Movie update(MovieBean movieBean) {
        //movieBean을 entity타입으로 변환
        return modelMapper.map(movieBean,Movie.class);
    }
}
