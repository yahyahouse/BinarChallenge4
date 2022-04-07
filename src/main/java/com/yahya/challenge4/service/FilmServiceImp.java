package com.yahya.challenge4.service;

import com.yahya.challenge4.model.Films;
import com.yahya.challenge4.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
public class FilmServiceImp implements FilmService{

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public void saveFilms(String nameFilm, String Tayang) {
        Films film = new Films();
        film.setFilmName(nameFilm);
        film.setTayang(Tayang);
        filmRepository.save(film);
    }

    @Override
    public Optional<Films> getFilm(Integer codeFilm) {
        return filmRepository.findById(codeFilm);
    }
}
