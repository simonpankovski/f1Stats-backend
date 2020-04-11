package com.project.f1.services;

import com.project.f1.domain.DriverStandings;
import com.project.f1.repositories.DriverStandingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DriverStandingsServiceImpl implements DriverStandingsService {
    @Autowired
    private DriverStandingsRepo driverStandingsRepo;
    @Override
    public List<DriverStandings> getAll() {
        return (List<DriverStandings>) driverStandingsRepo.findAll();
    }

    @Override
    public List<DriverStandings> getAllByRaceId(Long id) {
        return driverStandingsRepo.findAllByRaceIdOrderByPosition(id);
    }

    @Override
    public List<DriverStandings> getAllByDriverId(Long id) {
        return driverStandingsRepo.findAllByDriverId(id);
    }

    @Override
    public List<DriverStandings> getAllByPoints(Float id) {
        return driverStandingsRepo.findAllByPoints(id);
    }

    @Override
    public List<DriverStandings> getAllByRaceYear(Integer year) {
        return driverStandingsRepo.findAllByRace_Year(year);
    }
}
