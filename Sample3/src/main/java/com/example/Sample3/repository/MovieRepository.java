package com.example.Sample3.repository;

import com.example.Sample3.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findByOrderByNumDesc();
    Movie findByNum(int num);

}