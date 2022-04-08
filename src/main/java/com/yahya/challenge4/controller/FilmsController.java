package com.yahya.challenge4.controller;

import com.yahya.challenge4.model.Films;
import com.yahya.challenge4.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class FilmsController {

    @Autowired
    private FilmService filmService;

    public String addFilms(String nameFilm, Boolean Tayang){
        filmService.addFilms(nameFilm,Tayang);
        return"film berhasil ditambahkan";
    }
    public void getFilms(Integer codeFilm) {
        Films film = filmService.getFilm(codeFilm).get();
        System.out.println("Film Name : " + film.getFilmName() + "\nTayang : " + film.getTayang());
    }

    public String updateFilm(Integer filmCode, String filmName, Boolean Tayang){
        filmService.updateFilm(filmCode,filmName,Tayang);
        return "update berhasil";
    }

    public String deleteFilm(Integer filmCode,String filmName){
        filmService.deleteFilm(filmCode,filmName);
        return "berhasil menghapus";
    }

    public String filmTayang(Boolean Tayang){
        Optional<Films> film = filmService.getFilmTayang(Tayang);
        System.out.println("Film name: "+film.get().getFilmName());
        return "Done";
    }
}
