package com.yahya.challenge4.controller;

import com.yahya.challenge4.model.Schedules;
import com.yahya.challenge4.service.SchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class SchedulesController {
    @Autowired
    private SchedulesService schedulesService;

    public String addSchedule(Integer harga, String jamMulai, String jamSelesai, String tglTayang, Long filmCode){
        schedulesService.addSchedules(harga,jamMulai,jamSelesai,tglTayang,filmCode);
        return"jadwal berhasil ditambahkan";
    }
    public void findFilmsSchedules(Long filmId) {
        List<Schedules> list = schedulesService.findFilmsSchedules(filmId);
        if (list != null) {
            for (Schedules schedules : list)
                System.out.println("film\t\t: " + schedules.getFilmCode().getFilmName()
                        + "\ntanggal\t\t: " + schedules.getTglTayang()
                        + "\nJam Mulai\t: " + schedules.getJamMulai()
                        + "\nJam Selesai\t: " + schedules.getJamSelesai());
        } else System.out.println("Film tidak tayang");

    }

//    public void getSchedulesByCodeName(Long filmCode) {
//        Schedules schedule = schedulesService.getSchedulesByCodeName(filmCode);
//        System.out.println("Film \t: " + schedule.getFilmCode().getFilmCode()
//                + "\nHarga \t: " + schedule.getHarga()
//                + "\nTanggal \t: " + schedule.getTglTayang());
//    }
}
