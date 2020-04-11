package com.project.f1.services;

import com.project.f1.domain.Race;
import com.project.f1.repositories.RaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RaceServiceImpl implements RaceService {
    @Autowired
    private RaceRepo raceRepo;
    @Override
    public List<Race> getAllRacesByYear(Integer year) {
        return raceRepo.findAllByYear(year);
    }

    @Override
    public List<Race> getAllRacesByCircuitId(Long id) {
        return raceRepo.findByCircuitIdOrderByYear(id);
    }

    @Override
    public List<Race> getAllRacesByDate(String date) {
        return raceRepo.findAllByDate(date);
    }

    @Override
    public Iterable<Race> getAllRaces() {
        return raceRepo.findAll();
    }
}
