package com.example.Sample3.controller;

import com.example.Sample3.bean.MovieBean;
import com.example.Sample3.entity.Movie;
import com.example.Sample3.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(value = {"/","/movies"} )
    public String selectAll(Model model){
        List<Movie> movies = movieService.findByOrderByNumDesc();
        model.addAttribute("movies",movies);
        return "/movie/select";
    }
    @GetMapping(value="/movie/insert")
    public String insertGet(Model model){
        model.addAttribute("movieBean",new MovieBean());
        return "/movie/insert";
    }

    @PostMapping(value="/movie/insert")
    public String insertPost(@Valid MovieBean movieBean, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("movieBean",movieBean);
            return "/movie/insert";
        }

        Movie movie = Movie.insertMovie(movieBean);
        movieService.saveMovie(movie);

        return "redirect:/";
    }

    //@{'/movie/detail?num=' + ${bean.num}}
//    @GetMapping(value="/movie/detail")
//    public String detail(int num, Model model) {

    // @{'/movie/detail/' + ${bean.num}}
    @GetMapping(value="/movie/detail/{num}")
    //@PathVariable("num") 넘어가는 엔티티가 하나일 때 사용
    public String detail(@PathVariable("num") int num, Model model) {

        Movie movie = movieService.getMovieByNum(num);
        System.out.println(movie.getGenre());
        System.out.println(movie.getTime());

        model.addAttribute("movie",movie);

        return "/movie/detail";
    }

    @GetMapping(value = "movie/delete")
    public String movieDelete(int num){
        movieService.movieDelete(num);
        return "redirect:/movies";
    }

    @GetMapping(value={"/movie/update"})
    public String updateGet(
            @RequestParam Integer num,
            Model model){
        Movie movie = movieService.getMovieByNum(num);
        model.addAttribute("movieBean",movie);
        return "/movie/update";
    }//update

    @PostMapping(value="/movie/insert")
    public String updatePost(@Valid MovieBean movieBean, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("movieBean",movieBean);
            return "/movie/update";
        }

        Movie movie = Movie.update(movieBean);
        movieService.saveMovie(movie);

        return "redirect:/";
    }

    @PostMapping(value = "movie/checkDelete")
    public String chkDelete(int[] rowcheck){ // 14 5 7
        List<Integer> delList = new ArrayList<Integer>();
        for(int i=0; i<rowcheck.length; i++){
            System.out.println("num : " + rowcheck[i]);
            delList.add(rowcheck[i]);
        }
        movieService.deleteAllByNum(delList);
        return "redirect:/";
    }
}
