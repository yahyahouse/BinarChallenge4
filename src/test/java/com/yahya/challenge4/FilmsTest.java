package com.yahya.challenge4;

import com.yahya.challenge4.controller.FilmsController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FilmsTest {

    @Autowired
    private FilmsController filmController;

    @Test
    @DisplayName("Test menambahkan film")
    public void addFilm(){
        String tambah = filmController.addFilms("Captain America", "Tidak Tayang");
        Assertions.assertEquals("film berhasil ditambahkan",tambah);
    }

    @Test
    @DisplayName("Test GET Film")
    public void getFilms() {
        filmController.getFilms(1);
    }

    @Test
    @DisplayName("Test UPDATE film")
    public void updateFilm(){filmController.updateFilm(5,"Programer Naik Haji","Tayang");}

    @Test
    @DisplayName("Test DELETE film")
    public void deleteFilm(){
        filmController.deleteFilm(11,"Captain America");
    }
}
