package com.yahya.challenge4.service;

import com.yahya.challenge4.model.Films;
import com.yahya.challenge4.model.Schedules;
import com.yahya.challenge4.repository.SchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class SchedulesServiceImp implements SchedulesService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private SchedulesRepository schedulesRepository;

    @Autowired
    private FilmService filmService;

    @Override
    public void addSchedules(Integer harga, String jamMulai, String jamSelesai, String tglTayang, Long filmCode) {
        Schedules schedule = new Schedules();
        schedule.setHarga(harga);
        schedule.setJamMulai(jamMulai);
        schedule.setJamSelesai(jamSelesai);
        schedule.setTglTayang(tglTayang);
        Films film = filmService.findFilmCode(filmCode);
        schedule.setFilmCode(film);
        schedulesRepository.save(schedule);
    }

    @Override
    public List<Schedules> findFilmsSchedules(Long filmCode) {
        return schedulesRepository.findFilmsSchedules(filmCode);
    }

    @Override
    public Schedules getSchedulesById(Long scheduleId) {
        return schedulesRepository.findByScheduleId(scheduleId);
    }

}
