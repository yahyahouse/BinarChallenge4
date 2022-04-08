package com.yahya.challenge4.controller;

import com.yahya.challenge4.model.Films;
import com.yahya.challenge4.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class FilmsController {

    @Autowired
    private FilmService filmService;

    public String addFilms(String nameFilm, Boolean Tayang){
        filmService.addFilms(nameFilm,Tayang);
        return"film berhasil ditambahkan";
    }
    public Films getFilms(Long codeFilm) {
        Films film = filmService.getFilm(codeFilm).get();
        System.out.println("Film Name : " + film.getFilmName() + "\nTayang : " + film.getTayang());
        return film;
    }

    public String updateFilm(Long filmCode, String filmName, Boolean Tayang){
        filmService.updateFilm(filmCode,filmName,Tayang);
        return "update berhasil";
    }

    public String deleteFilm(String filmName){
        filmService.deleteFilm(filmName);
        return "berhasil menghapus";
    }

    public List<Films> filmTayang(Boolean Tayang){
        List<Films> films = filmService.getFilmTayang(Tayang);
        films.forEach(film ->{
            System.out.println(film.getFilmName());
        });
        return films;
    }

}
