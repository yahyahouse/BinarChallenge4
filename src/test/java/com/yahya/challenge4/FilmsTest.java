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
        String tambah = filmController.addFilms("Programer Naik Haji", true);
        Assertions.assertEquals("film berhasil ditambahkan",tambah);
    }

    @Test
    @DisplayName("Test GET Film")
    public void getFilms() {
        filmController.getFilms(3);
    }

    @Test
    @DisplayName("Test UPDATE film")
    public void updateFilm(){filmController.updateFilm(5,"Programer Naik Haji",true);}

    @Test
    @DisplayName("Test DELETE film")
    public void deleteFilm(){
        filmController.deleteFilm(11,"Captain America");
    }

    @Test
    @DisplayName("Test menampilkan film tayang")
    public void filmTayang(){
        filmController.filmTayang(false);
    }
}
