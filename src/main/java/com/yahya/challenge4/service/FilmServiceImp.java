package com.yahya.challenge4.service;

import com.yahya.challenge4.model.Films;
import com.yahya.challenge4.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImp implements FilmService{

    @PersistenceContext
    private EntityManager em;


    @Autowired
    private FilmRepository filmRepository;

    @Override
    public void addFilms(String nameFilm, Boolean Tayang) {
        Films film = new Films();
        film.setFilmName(nameFilm);
        film.setTayang(Tayang);
        filmRepository.save(film);
    }

    @Override
    public Optional<Films> getFilm(Long codeFilm) {
        return filmRepository.getFilmName(codeFilm);
    }

    @Override
    public void updateFilm(Long filmCode, String filmNameNew, Boolean TayangNew) {
        filmRepository.updateFilm(filmCode,filmNameNew,TayangNew);
    }

    @Override
    public void deleteFilm(String filmName) {
        filmRepository.deleteFilm(filmName);
    }

    @Override
    public void deleteFilmById(Long filmCode) {
        filmRepository.deleteFilmById(filmCode);
    }

    @Override
    public List<Films> getFilmTayang(Boolean Tayang) {
        return filmRepository.sedangTayang(Tayang);
    }

    @Override
    public List<Films> getAll() {
        return filmRepository.findAll();
    }

}
