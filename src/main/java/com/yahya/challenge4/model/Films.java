package com.yahya.challenge4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "films")
public class Films {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "film_code")
    private Integer filmCode;

    @Column(name = "film_name")
    private String filmName;

    @Column(name = "tayang")
    private Boolean tayang;

}
