package com.yahya.challenge4.controller;

import com.yahya.challenge4.model.Films;
import com.yahya.challenge4.service.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/film/api")
public class FilmsController {

    @Autowired
    private FilmService filmService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Berhasil Menambahkan film",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Films.class)) }),
            @ApiResponse(responseCode = "400", description = "Gagal Menambahkan Film",
                    content = @Content) })
    @Operation(summary = "menambahkan film ke tabel film pada database")
    @PostMapping("/add-film")
    public String addFilms(String nameFilm, Boolean Tayang){
        filmService.addFilms(nameFilm,Tayang);
        return"film berhasil ditambahkan";
    }

    @Operation(summary = "menampilkan film sesuai dengan code film yang dimasukan")
    @GetMapping(value="/get-film/{codeFilm}")
    public Films getFilms(@PathVariable("codeFilm") Long codeFilm) {
        Films film = filmService.getFilm(codeFilm).get();
        System.out.println("Film Name : " + film.getFilmName() + "\nTayang : " + film.getTayang());
        return film;
    }

    @Operation(summary = "mengubah isi tabel film yang sudah ada pada database")
    @PutMapping(value="/update-film")
    public String updateFilm(Long filmCode, String filmName, Boolean Tayang){
        filmService.updateFilm(filmCode,filmName,Tayang);
        return "update berhasil";
    }

    @Operation(summary = "menghapus isi tabel film sesuai dengan nama film")
    @DeleteMapping(value="/delete-film/{filmName}")
    public String deleteFilm(@PathVariable("filmName")String filmName){
        filmService.deleteFilm(filmName);
        return "berhasil menghapus";
    }

    @Operation(summary = "menghapus isi tabel film sesuai dengan code film")
    @DeleteMapping(value = "/delete-film-by-id/{filmCode}")
    public  String deleteFilmById(@PathVariable("filmCode")Long filmCode){
        filmService.deleteFilmById(filmCode);
        return  "berhasil dihapus";
    }

    @Operation(summary = "menampilkan isi tabel film yang sedang tayang")
    @GetMapping(value = "/film-sedang-tayang")
    public List<Films> filmTayang(Boolean Tayang){
        List<Films> films = filmService.getFilmTayang(Tayang);
        films.forEach(film ->{
            System.out.println(film.getFilmName());
        });
        return films;
    }

    @Operation(summary = "menampilkan semua isi tabel pada tabel film")
    @RequestMapping(value ="/film",method = RequestMethod.GET)
    public List<Films> allFilms(){
        List<Films> films = filmService.getAll();
        films.forEach(film->{
            System.out.println(film.getFilmCode());
            System.out.println(film.getFilmName());
        });
        return films;
    }

}
