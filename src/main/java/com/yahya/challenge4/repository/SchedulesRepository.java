package com.yahya.challenge4.repository;

import com.yahya.challenge4.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Integer> {


    @Query(value = "insert into schedules (harga,jam_mulai,jam_selesai,tgl_tayang,film_code) values(?1,?2,?3,?4,?5)", nativeQuery = true)
    public void insertFilm(Integer harga, String jamMulai, String jamSelesai, String tglTayang, Long filmCode);

    @Query(value = "select * from schedules s where s.film_code=?1", nativeQuery = true)
    List<Schedules> findFilmsSchedules(Long filmCode);

    public Schedules findByScheduleId(Long scheduleId);

}
