package com.yahya.challenge4.controller;

import com.yahya.challenge4.model.Films;
import com.yahya.challenge4.service.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/film/api")
public class FilmsController {

    private static final Logger LOG = LoggerFactory.getLogger(FilmsController.class);

    @Autowired
    private FilmService filmService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Berhasil Menambahkan film",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Films.class))}),
            @ApiResponse(responseCode = "400", description = "Gagal Menambahkan Film",
                    content = @Content)})
    @Operation(summary = "menambahkan film ke tabel film pada database")
    @PostMapping("/add-film")
    public ResponseEntity<HttpStatus> addFilms(@Schema(example = "{" +
            "\"nameFilm\":\"Programmer naik haji\"," +
            "\"tayang\":\"1\"" +
            "}") @RequestBody Map<String, Object> film) {
        filmService.addFilms(film.get("nameFilm").toString(), Boolean.valueOf(film.get("tayang").toString()));
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.put("Binar", Arrays.asList("Test"));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Berhasil Menampilkan FIlm",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Films.class))})})
    @Operation(summary = "menampilkan film sesuai dengan code film yang dimasukan")
    @GetMapping(value = "/get-film/{codeFilm}")
    public ResponseEntity<Optional<Films>> getFilms(@Schema(example = "{" +
            "\"codeFilm\":\"1\"," +
            "}") @PathVariable("codeFilm") Long codeFilm) {
        Optional<Films> films= filmService.getFilm(codeFilm);
        LOG.info("Jumlah Film: {}", films);
        return ResponseEntity.ok(films);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Berhasil meng-Update FIlm",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Films.class))})})
    @Operation(summary = "mengubah isi tabel film yang sudah ada pada database")
    @PutMapping(value = "/update-film")
    public String updateFilm(@Schema(example = "{" +
            "\"filmCode\":\"1\"," +
            "\"filmName\":\"Programmer naik haji\"," +
            "\"tayang\":\"1\"" +
            "}") @RequestBody Map<String, Object> film) {
        filmService.updateFilm(Long.valueOf(film.get("filmCode").toString()),film.get("filmName").toString(), Boolean.valueOf(film.get("tayang").toString()));
        return "update berhasil";
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Berhasil Menghapus FIlm",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Films.class))})})
    @Operation(summary = "menghapus isi tabel film sesuai dengan nama film")
    @DeleteMapping(value = "/delete-film/{filmName}")
    public String deleteFilm(@Schema(example = "{" +
            "\"filmName\":\"Programmer naik haji\"," +
            "}") @PathVariable("filmName") String filmName) {
        filmService.deleteFilm(filmName);
        return "berhasil menghapus";
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Berhasil Menghapus FIlm",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Films.class))})})
    @Operation(summary = "menghapus isi tabel film sesuai dengan code film")
    @DeleteMapping(value = "/delete-film-by-id/{filmCode}")
    public String deleteFilmById(@Schema(example = "{" +
            "\"filmCode\":\"1\"," +
            "}") @PathVariable("filmCode") Long filmCode) {
        filmService.deleteFilmById(filmCode);
        return "berhasil dihapus";
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Berhasil Menampilkan FIlm",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Films.class))})})
    @Operation(summary = "menampilkan isi tabel film yang sedang tayang")
    @GetMapping(value = "/film-sedang-tayang")
    public List<Films> filmTayang(@Schema(example = "{" +
            "\"tayang\":\"1\"," +
            "}") Boolean Show) {
        List<Films> films = filmService.getFilmTayang(Show);
        films.forEach(film -> LOG.info(film.getFilmName()));
        return films;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Berhasil Menampilkan FIlm",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Films.class))})})
    @Operation(summary = "menampilkan semua isi tabel pada tabel film")
    @GetMapping(value = "/film")
    public List<Films> allFilms() {
        List<Films> films = filmService.getAll();
        LOG.info("Film ditampilkan");
        return films;
    }

}
