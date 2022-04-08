package com.yahya.challenge4.repository;

import com.yahya.challenge4.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface FilmRepository extends JpaRepository<Films,Integer> {

    @Query(value="insert into films(film_code,film_name,tayang) values(?1,?2,?3)",nativeQuery = true)
    public void insertFilm(Integer filmCode,String nameFilm, String tayang);

    @Transactional
    @Modifying
    @Query("UPDATE films f SET f.filmName=?2, f.tayang=?3 WHERE f.filmCode=?1")
    void updateFilm(Integer filmCode,String filmName,String Tayang);

    @Transactional
    @Modifying
    @Query("DELETE FROM films f WHERE f.filmCode=?1 and f.filmName=?2")
    void deleteFilm(Integer filmCode,String filmName);
}
