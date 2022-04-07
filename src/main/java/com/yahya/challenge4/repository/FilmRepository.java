package com.yahya.challenge4.repository;

import com.yahya.challenge4.model.Films;
import com.yahya.challenge4.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
public interface FilmRepository extends JpaRepository<Films,Integer> {

    @Query(value="insert into films(film_code,film_name,tayang) values(?1,?2,?3)",nativeQuery = true)
    public void insertFilm(Integer filmCode,String nameFilm, String tayang);

}
