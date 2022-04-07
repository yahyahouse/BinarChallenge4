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
        String tambah = filmController.addFilms("Eat", "Tayang");
        Assertions.assertEquals("film berhasil ditambahkan",tambah);
    }

    @Test
    @DisplayName("Test GET Film")
    public void getUser() {
        filmController.getFilms(1);
    }
}
