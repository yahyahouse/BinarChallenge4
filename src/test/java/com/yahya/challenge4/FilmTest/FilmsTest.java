package com.yahya.challenge4.FilmTest;

import com.yahya.challenge4.controller.FilmsController;
import com.yahya.challenge4.service.FilmService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilmsTest {

    @Autowired
    private FilmsController filmController;
    @Autowired
    private FilmService filmService;

    @Test
    @DisplayName("Test menambahkan film")
    void addFilm(){
        Assertions.assertDoesNotThrow(() -> filmService.addFilms("Programer Naik Haji", true));
    }

    @Test
    @DisplayName("Test GET Film")
    void getFilms() {
        Assertions.assertDoesNotThrow(() ->filmController.getFilms(6L));
    }


    @Test
    @DisplayName("Test DELETE film")
    void deleteFilm(){
        Assertions.assertDoesNotThrow(() ->filmController.deleteFilm("Programer Naik Haji"));
    }

    @Test
    @DisplayName("Test menampilkan film tayang")
    void filmTayang(){
        Assertions.assertDoesNotThrow(() ->filmController.filmTayang(true));
    }

    @Test
    @DisplayName("Test mengambil data semua film")
    void getAll(){
        Assertions.assertDoesNotThrow(() ->filmController.allFilms());
    }

}
