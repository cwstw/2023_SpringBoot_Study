package com.example.Sample3.service;

import com.example.Sample3.entity.Movie;
import com.example.Sample3.repository.MovieRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;


    public List<Movie> findByOrderByNumDesc() {
        List<Movie> movies = movieRepository.findByOrderByNumDesc();
        return movies;
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie getMovieByNum(int num) {
        Movie movie = movieRepository.findByNum(num);
        return movie;
    }

    public void movieDelete(int num) {
        Movie movie = movieRepository.findByNum(num); // select * from movie where num=20
        movieRepository.delete(movie);
    }

    public void deleteAllByNum(List<Integer> row) {
        movieRepository.deleteAllById(row);
    }
}