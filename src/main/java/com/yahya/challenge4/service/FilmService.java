package com.yahya.challenge4.service;


import com.yahya.challenge4.model.Films;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FilmService {
    public void addFilms(String nameFilm, Boolean tayang);

    Optional<Films> getFilm(Long codeFilm);

    public void updateFilm(Long filmCode, String filmNameNew, Boolean tayangNew);

    public void deleteFilm(String filmName);

    void deleteFilmById(Long filmCode);

    List<Films> getFilmTayang(Boolean tayang);

    List<Films> getAll();

    public Films findFilmCode(Long filmCode);


}
