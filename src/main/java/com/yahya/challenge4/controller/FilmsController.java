package com.yahya.challenge4.controller;

import com.yahya.challenge4.model.Films;
import com.yahya.challenge4.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/film/api")
public class FilmsController {

    @Autowired
    private FilmService filmService;


    @PostMapping("/add-film")
    public String addFilms(String nameFilm, Boolean Tayang){
        filmService.addFilms(nameFilm,Tayang);
        return"film berhasil ditambahkan";
    }

    @GetMapping(value="/get-film/{codeFilm}")
    public Films getFilms(@PathVariable("codeFilm") Long codeFilm) {
        Films film = filmService.getFilm(codeFilm).get();
        System.out.println("Film Name : " + film.getFilmName() + "\nTayang : " + film.getTayang());
        return film;
    }

    @PutMapping(value="/update-film")
    public String updateFilm(Long filmCode, String filmName, Boolean Tayang){
        filmService.updateFilm(filmCode,filmName,Tayang);
        return "update berhasil";
    }

    @DeleteMapping(value="/delete-film/{filmName}")
    public String deleteFilm(@PathVariable("filmName")String filmName){
        filmService.deleteFilm(filmName);
        return "berhasil menghapus";
    }

    @DeleteMapping(value = "/delete-film-by-id/{filmCode}")
    public  String deleteFilmById(@PathVariable("filmCode")Long filmCode){
        filmService.deleteFilmById(filmCode);
        return  "berhasil dihapus";
    }

    @GetMapping(value = "/film-sedang-tayang")
    public List<Films> filmTayang(Boolean Tayang){
        List<Films> films = filmService.getFilmTayang(Tayang);
        films.forEach(film ->{
            System.out.println(film.getFilmName());
        });
        return films;
    }

    @RequestMapping(value ="/film",method = RequestMethod.GET)
    public List<Films> allFilms(){
        List<Films> films = filmService.getAll();
        films.forEach(film->{
            System.out.println(film.getFilmCode());
            System.out.println(film.getFilmName());
        });
        return films;
    }

}
