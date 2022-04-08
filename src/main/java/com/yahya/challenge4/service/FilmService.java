package com.yahya.challenge4.service;


import com.yahya.challenge4.model.Films;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface FilmService {
    public void addFilms(String nameFilm, Boolean Tayang);
    public Optional<Films> getFilm(Integer codeFilm);
    public void updateFilm(Integer filmCode, String filmNameNew, Boolean TayangNew);
    public void deleteFilm(Integer filmCode,String filmName);
    Optional<Films> getFilmTayang (Boolean Tayang);
}
