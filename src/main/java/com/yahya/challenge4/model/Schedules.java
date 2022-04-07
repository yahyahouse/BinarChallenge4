package com.yahya.challenge4.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "schedules")
public class Schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id")
    private Integer scheduleId;

    @OneToMany
    @JoinColumn(name = "film_code")
    private List<Films> filmCode;

    @Column(name="tgl_tayang")
    private Date tglTayang;

    @Column(name ="jam_mulai")
    private String jamMulai;

    @Column(name="jam_selesai")
    private String jamSelesai;

    @Column(name="harga")
    private Integer harga;
}
