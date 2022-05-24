package com.yahya.challenge4.repository;

import com.yahya.challenge4.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, Integer> {
    @Query(value = "insert into seats values(?1,?2)", nativeQuery = true)
    public void insertFilm();

    @Query("SELECT s FROM seats s WHERE s.Id.noKursi=?1 and s.Id.studioName=?2")
    public Seats findNoKursi(Integer noKursi, String studioName);

}
