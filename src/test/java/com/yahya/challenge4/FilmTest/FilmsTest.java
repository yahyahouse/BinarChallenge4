package com.yahya.challenge4.FilmTest;

import com.yahya.challenge4.controller.FilmsController;
import com.yahya.challenge4.service.FilmService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FilmsTest {

    @Autowired
    private FilmsController filmController;
    @Autowired
    private FilmService filmService;

    @Test
    @DisplayName("Test menambahkan film")
    public void addFilm(){
        filmService.addFilms("Programer Naik Haji", true);
    }

    @Test
    @DisplayName("Test GET Film")
    public void getFilms() {
        filmController.getFilms(6L);
    }

//    @Test
//    @DisplayName("Test UPDATE film")
////    public void updateFilm(){filmController.updateFilm(1L,"Programer Naik Haji",true);}

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

    @Test
    @DisplayName("Test mengambil data semua film")
    public void getAll(){
        filmController.allFilms();
    }

}
