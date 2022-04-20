package com.yahya.challenge4.service;


import com.yahya.challenge4.model.Films;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FilmService {
    public void addFilms( String nameFilm, Boolean Tayang);
    Optional<Films> getFilm(Long codeFilm);
    public void updateFilm(Long filmCode, String filmNameNew, Boolean TayangNew);
    public void deleteFilm(String filmName);
    void deleteFilmById(Long filmCode);
    List<Films> getFilmTayang (Boolean Tayang);
    List<Films> getAll();
    public Films findFilmCode(Long filmCode);


}
