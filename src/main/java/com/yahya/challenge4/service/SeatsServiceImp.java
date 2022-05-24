package com.yahya.challenge4.service;

import com.yahya.challenge4.model.Seats;
import com.yahya.challenge4.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatsServiceImp implements SeatsService {
    @Autowired
    private SeatsRepository seatsRepository;

    @Override
    public Seats getNoKursi(Integer noKursi, String studioName) {

        return seatsRepository.findNoKursi(noKursi, studioName);
    }
}
