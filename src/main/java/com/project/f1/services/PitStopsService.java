package com.project.f1.services;

import com.project.f1.domain.PitStops;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PitStopsService {
    List<PitStops> getAllByStopEquals(Integer stop);
    List<PitStops> getAllByMillisecondsGreaterThanEqual(Integer milliseconds);
    List<PitStops> getAllByRaceId(Long id);
    List<PitStops> getAllByDriverId(Long id);
    List<PitStops> getAllByDriverIdAndRaceId(Long driverId, Long raceId);
    List<PitStops> getAllByDurationGreaterThanEqual(String duration);
}
