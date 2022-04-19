package com.yahya.challenge4.service;

import com.yahya.challenge4.model.Schedules;
import com.yahya.challenge4.repository.FilmRepository;
import com.yahya.challenge4.repository.SchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class SchedulesServiceImp implements SchedulesService{
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private SchedulesRepository schedulesRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public void addSchedules(Integer harga, String jamMulai, String jamSelesai, String tglTayang, Long filmCode) {
        Schedules schedule = new Schedules();
        schedule.setHarga(harga);
        schedule.setJamMulai(jamMulai);
        schedule.setJamSelesai(jamSelesai);
        schedule.setTglTayang(tglTayang);
        schedule.setFilmCode(filmRepository.getById(1));
        schedulesRepository.save(schedule);
    }

    @Override
    public List<Schedules> findFilmsSchedules(Long filmCode) {
        return schedulesRepository.findFilmsSchedules(filmCode);
    }

//    @Override
//    public Schedules getSchedulesById(Long filmCode) {
//        String query = "SELECT f.film_name as film , s.harga as harga\n" +
//                "FROM schedules s\n" +
//                "inner JOIN films f ON f.film_code=s.film_code " +
//                "where s.film_code =?1";
//        Query q =  em.createNativeQuery(query);
//        q.setParameter(1, filmCode);
//        return (Schedules) q.getSingleResult();
//    }

//    @Override
//    public Schedules getSchedulesByCodeName(Long filmCode) {
//        return schedulesRepository.findFilmCode(filmCode);
//    }

}
