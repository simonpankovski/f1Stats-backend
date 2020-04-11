package com.project.f1.services;

import com.project.f1.domain.Driver;
import com.project.f1.domain.LapTimes;
import com.project.f1.domain.Race;
import com.project.f1.repositories.LapTimesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LapTimesServiceImpl implements LapTimesService {
    @Autowired
    private LapTimesRepo lapTimesRepo;
    @Override
    public List<LapTimes> getAllByRace(Long id) {
        return lapTimesRepo.findAllByRaceId(id);
    }

    @Override
    public List<LapTimes> getAllByDriver(Long id) {
        return lapTimesRepo.findAllByDriverId(id);
    }

    @Override
    public List<LapTimes> getAllByCircuit(Long id) {
        return lapTimesRepo.findAllByRace_Circuit_IdOrderByMilliseconds(id);
    }

    @Override
    public List<LapTimes> getAllByDriverAndCircuit(Long driverId, Long circuitId) {
        return lapTimesRepo.findAllByDriverIdAndRace_Circuit_IdOrderByMilliseconds(driverId,circuitId);
    }

    @Override
    public List<LapTimes> getAllByDriverAndRace(Long driverId, Long raceId) {
        return lapTimesRepo.findAllByDriverIdAndRaceIdOrderByMilliseconds(driverId,raceId);
    }
}
