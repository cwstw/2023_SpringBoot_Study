package com.example.Sample5.controller;

import com.example.Sample5.bean.GameBean;
import com.example.Sample5.entity.GameEntity;
import com.example.Sample5.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping(value = {"/","/game"})
    public String gameList(Model model){
        List<GameEntity> games = gameService.findByOrderByNumDesc();
        model.addAttribute("games",games);
        return "/game/select";
    }//gameList

    @GetMapping(value = "/game/insert")
    public String gameInsert(Model model){

        String[] lang = {"한국어","영어","일본어","중국어","독일어","프랑스어"};
        String[] genre = {"액션", "어드벤처", "좀비", "FPS", "공포", "추리", "로그라이크", "퍼즐", "힐링"};
        String[] platform = {"Nitendo Switch", "PS", "PC", "Android", "IOS"};
        model.addAttribute("gameBean",new GameBean());
        model.addAttribute("lang",lang);
        model.addAttribute("genre",genre);
        model.addAttribute("platform",platform);
        return "/game/insertForm";
    }//gameInsert

    @PostMapping(value = "/game/insert")
    public String gameInsert(
            @Valid GameBean gameBean,
            BindingResult result,
            Model model){

        String[] lang = {"한국어","영어","일본어","중국어","독일어","프랑스어"};
        String[] genre = {"액션", "어드벤처", "좀비", "FPS", "공포", "추리", "로그라이크", "퍼즐", "힐링"};
        String[] platform = {"Nitendo Switch", "PS", "PC", "Android", "IOS"};

        if(result.hasErrors()){
            //에러가 있으면
            model.addAttribute("lang",lang);
            model.addAttribute("genre",genre);
            model.addAttribute("platform",platform);
            model.addAttribute("gameBean",gameBean);
            return "/game/insertForm";
        }
        //에러가 없으면

        //bean을 entity로 변환
        GameEntity game = GameEntity.insertGame(gameBean);
        gameService.saveGame(game);

        return "redirect:/";
    }//gameInsert

    @GetMapping(value = "/game/update/{num}")
    public String gameUpdate(
            @PathVariable("num") int num,
            Model model){

        GameEntity game = gameService.findByNum(num);
        System.out.println("game title : "+game.getTitle());

        String[] lang = {"한국어","영어","일본어","중국어","독일어","프랑스어"};
        String[] genre = {"액션", "어드벤처", "좀비", "FPS", "공포", "추리", "로그라이크", "퍼즐", "힐링"};
        String[] platform = {"Nitendo Switch", "PS", "PC", "Android", "IOS"};

        model.addAttribute("gameBean",game);
        model.addAttribute("lang",lang);
        model.addAttribute("genre",genre);
        model.addAttribute("platform",platform);
        return "/game/updateForm";
    }//gameUpdate
    @PostMapping(value = "/game/update")
    public String gameUpdate(
            @Valid GameBean gameBean,
            BindingResult result,
            Model model){

        String[] lang = {"한국어","영어","일본어","중국어","독일어","프랑스어"};
        String[] genre = {"액션", "어드벤처", "좀비", "FPS", "공포", "추리", "로그라이크", "퍼즐", "힐링"};
        String[] platform = {"Nitendo Switch", "PS", "PC", "Android", "IOS"};

        if(result.hasErrors()){
            //에러가 있으면
            model.addAttribute("lang",lang);
            model.addAttribute("genre",genre);
            model.addAttribute("platform",platform);
            model.addAttribute("gameBean",gameBean);
            return "/game/updateForm";
        }
        //에러가 없으면

        //bean을 entity로 변환
        GameEntity game = GameEntity.insertGame(gameBean);
        gameService.saveGame(game);

        return "redirect:/";
    }//gameUpdate

    @GetMapping("/game/delete/{num}")
    public String gameDelete(@PathVariable("num") int num){
        gameService.deleteGame(num);
        return "redirect:/";
    }//gameDelete

    @PostMapping("/game/checkDelete")
    public String gameCheckDelete(int[] row){
        //row의 길이만큼 반복해서 삭제
        for(int i = 0; i < row.length; i++){
            gameService.deleteGame(row[i]);
        }
        return "redirect:/";
    }//gameCheckDelete

    @GetMapping("/game/detail")
    public String gameDetail(@RequestParam("num") int num, Model model){
        GameEntity game = gameService.findByNum(num);
        model.addAttribute("game",game);
        return "/game/detail";
    }
}
