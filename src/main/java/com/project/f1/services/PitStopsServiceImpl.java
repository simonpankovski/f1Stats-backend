package com.project.f1.services;

import com.project.f1.domain.PitStops;
import com.project.f1.repositories.PitStopsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PitStopsServiceImpl implements PitStopsService {
    @Autowired
    private PitStopsRepo pitStopsRepo;
    @Override
    public List<PitStops> getAllByStopEquals(Integer stop) {
        return pitStopsRepo.findAllByStopEquals(stop);
    }

    @Override
    public List<PitStops> getAllByMillisecondsGreaterThanEqual(Integer milliseconds) {
        return pitStopsRepo.findAllByMillisecondsGreaterThanEqual(milliseconds);
    }

    @Override
    public List<PitStops> getAllByRaceId(Long id) {
        return pitStopsRepo.findAllByRaceId(id);
    }

    @Override
    public List<PitStops> getAllByDriverId(Long id) {
        return pitStopsRepo.findAllByDriverId(id);
    }

    @Override
    public List<PitStops> getAllByDriverIdAndRaceId(Long driverId, Long raceId) {
        return pitStopsRepo.findAllByDriverIdAndRaceId(driverId, raceId);
    }

    @Override
    public List<PitStops> getAllByDurationGreaterThanEqual(String duration) {
        return pitStopsRepo.findAllByDurationGreaterThanEqual(duration);
    }
}
