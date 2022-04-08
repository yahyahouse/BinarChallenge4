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
        filmController.getFilms(1L);
    }

    @Test
    @DisplayName("Test UPDATE film")
    public void updateFilm(){filmController.updateFilm(1L,"Programer Naik Gaji",true);}

    @Test
    @DisplayName("Test DELETE film")
    public void deleteFilm(){
        filmController.deleteFilm("Programer Naik Haji");
    }

    @Test
    @DisplayName("Test menampilkan film tayang")
    public void filmTayang(){
        filmController.filmTayang(true);
    }

}
