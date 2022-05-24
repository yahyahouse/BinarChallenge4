package com.yahya.challenge4.repository;

import com.yahya.challenge4.model.Films;
import com.yahya.challenge4.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public interface FilmRepository extends JpaRepository<Films, Integer> {

//    @Query(value="insert into films(film_code,film_name,tayang) values(?1,?2,?3)",nativeQuery = true)
//    public void insertFilm(Integer filmCode,String nameFilm, Boolean tayang);

    @Transactional
    @Modifying
    @Query("UPDATE films f SET f.filmName=?2, f.tayang=?3 WHERE f.filmCode=?1")
    void updateFilm(Long filmCode, String filmName, Boolean Tayang);

    @Transactional
    @Modifying
    @Query("DELETE FROM films f WHERE f.filmName=?1")
    void deleteFilm(String filmName);

    @Transactional
    @Modifying
    @Query("DELETE FROM films f WHERE f.filmCode=?1")
    void deleteFilmById(Long filmCode);

    @Query("SELECT f FROM films f WHERE f.tayang=:tayang")
    List<Films> sedangTayang(Boolean tayang);

    @Query("SELECT f FROM films f WHERE f.filmCode=:filmCode")
    Optional<Films> getFilmName(Long filmCode);

    @Query("select s from schedules s where s.filmCode =:filmCode")
    List<Schedules> findByFilmCode(Long filmCode);

    @Query("select f from films f where f.filmCode=:filmCode")
    Films findFilmCode(Long filmCode);


}
