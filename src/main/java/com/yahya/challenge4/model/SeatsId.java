package com.yahya.challenge4.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class SeatsId implements Serializable {
    public enum studioName{
        A,B,C;
    }
    @Enumerated(EnumType.ORDINAL)
    private studioName studioName;
    private Integer noKursi;
}
