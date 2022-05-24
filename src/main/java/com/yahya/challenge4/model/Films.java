package com.yahya.challenge4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "films")
public class Films {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_code")
    private Long filmCode;

    @Column(name = "film_name")
    private String filmName;

    @Column(name = "tayang")
    private Boolean tayang;

    public Films() {

    }

    @Override
    public String toString() {
        return "films [  film_id : " + filmCode + "" +
                "\n\t\t film_name : " + filmName + " \n\t\t tayang : " + tayang + " ]";
    }

    public Films(String filmName, Boolean tayang) {
        this.filmName = filmName;
        this.tayang = tayang;
    }


}
