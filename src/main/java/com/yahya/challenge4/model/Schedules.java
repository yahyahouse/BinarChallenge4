package com.yahya.challenge4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "schedules")
public class Schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long scheduleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_code")
    private Films filmCode;

    @Column(name="tgl_tayang")
    private String tglTayang;

    @Column(name ="jam_mulai")
    private String jamMulai;

    @Column(name="jam_selesai")
    private String jamSelesai;

    @Column(name="harga")
    private Integer harga;

    @Override
    public String toString() {
        return "Schedules{" +
                "scheduleId=" + scheduleId +
                ", tglTayang=" + tglTayang +
                ", harga=" + harga +
                ", jamMulai=" + jamMulai +
                ", jamSelesai=" + jamSelesai +
                ", films=" + filmCode +
                '}';
    }

}
