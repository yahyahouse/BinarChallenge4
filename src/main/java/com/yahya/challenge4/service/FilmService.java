package com.yahya.challenge4.service;


import com.yahya.challenge4.model.Films;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface FilmService {
    public void saveFilms(String nameFilm, String Tayang);
    public Optional<Films> getFilm(Integer codeFilm);
}
