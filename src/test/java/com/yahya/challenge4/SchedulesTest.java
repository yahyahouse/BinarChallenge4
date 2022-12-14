package com.yahya.challenge4;

import com.yahya.challenge4.controller.SchedulesController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SchedulesTest {
    @Autowired
    private SchedulesController schedulesController;

    @Test
    @DisplayName("Test menampilkan jadwal film tertentu")
    public void getJadwalFilm(){
        schedulesController.findFilmsSchedules(1L);
    }

//    @Test
//    @DisplayName("Test menambahkan Schedules")
//    public void addSchedules(){
//        schedulesController.addSchedule(45000,"13.00","15.00","5 Maret 2021",1L);
//    }
}
