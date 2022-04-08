package com.yahya.challenge4.repository;

import com.yahya.challenge4.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchedulesRepository extends JpaRepository<Schedules,Integer> {
//    @Query("select s from schedules s where s.filmCode=:filmCode")
//    Optional<Schedules> findFilmsSchedules(Long filmCode);

    @Query("select s from schedules s where s.scheduleId =:scheduleId")
    Optional<Schedules> findByScheduleId(Long scheduleId);

    @Query(value="insert into schedules (harga,jam_mulai,jam_selesai,tgl_tayang,film_code) values(?1,?2,?3,?4,?5)",nativeQuery = true)
    public void insertFilm(Integer harga, String jamMulai, String jamSelesai, String tglTayang, Long filmCode);


//    Schedules findFilmCode(Long filmCode);

    @Query(value = "select * from schedules s where s.film_code=?1", nativeQuery = true)
    List<Schedules> findFilmsSchedules(Long filmId);


}
