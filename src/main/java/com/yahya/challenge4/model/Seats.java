package com.yahya.challenge4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name="seats")
public class Seats {
    @EmbeddedId
    private SeatsId Id;
}
