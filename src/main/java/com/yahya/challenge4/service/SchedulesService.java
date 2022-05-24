package com.yahya.challenge4.service;

import com.yahya.challenge4.model.Schedules;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchedulesService {

    void addSchedules(Integer harga, String jamMulai, String jamSelesai, String tglTayang, Long filmCode);

    List<Schedules> findFilmsSchedules(Long filmCode);

    //    public Schedules getSchedulesById(Long filmCode);
//    public Schedules getSchedulesByCodeName(Long filmCode);
    public Schedules getSchedulesById(Long scheduleId);

}
