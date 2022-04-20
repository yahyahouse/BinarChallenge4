package com.yahya.challenge4.controller;

import com.yahya.challenge4.model.Schedules;
import com.yahya.challenge4.service.SchedulesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/schedules/api")
public class SchedulesController {
    @Autowired
    private SchedulesService schedulesService;

    @Operation(summary = "menambahkan jadwal pada tabel schedules di database")
    @PostMapping(value = "/add-schedules")
    public String addSchedule(Integer harga, String jamMulai, String jamSelesai, String tglTayang, Long filmCode){
        schedulesService.addSchedules(harga,jamMulai,jamSelesai,tglTayang,filmCode);
        return"jadwal berhasil ditambahkan";
    }

    @Operation(summary = "menampilkan jadwal film sesuai dengan code film")
    @GetMapping(value="/film-schedules/{filmCode}")
    public List<Schedules> findFilmsSchedules(@PathVariable("filmCode") Long filmCode) {
        List<Schedules> schedules = schedulesService.findFilmsSchedules(filmCode);
        schedules.forEach(s->{
            System.out.println(s.getFilmCode().getFilmName());
            System.out.println(s.getTglTayang());
            System.out.println(s.getJamMulai());
            System.out.println(s.getJamSelesai());
            System.out.println(s.getHarga());
        });
//        if (list != null) {
//            for (Schedules schedules : list)
//                System.out.println("film\t\t: " + schedules.getFilmCode().getFilmName()
//                        + "\ntanggal\t\t: " + schedules.getTglTayang()
//                        + "\nJam Mulai\t: " + schedules.getJamMulai()
//                        + "\nJam Selesai\t: " + schedules.getJamSelesai());
//        } else System.out.println("Film tidak tayang");

        return schedules;
    }

//    public void getSchedulesByCodeName(Long filmCode) {
//        Schedules schedule = schedulesService.getSchedulesByCodeName(filmCode);
//        System.out.println("Film \t: " + schedule.getFilmCode().getFilmCode()
//                + "\nHarga \t: " + schedule.getHarga()
//                + "\nTanggal \t: " + schedule.getTglTayang());
//    }
}
