package com.project.f1.services;

import com.project.f1.domain.Driver;
import com.project.f1.domain.LapTimes;
import com.project.f1.domain.Race;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LapTimesService {
    List<LapTimes> getAllByRace(Long id);
    List<LapTimes> getAllByDriver(Long id);
    List<LapTimes> getAllByDriverAndRace(Long driverId,Long raceId);
    List<LapTimes> getAllByDriverAndCircuit(Long driverId,Long circuitId);
    List<LapTimes> getAllByCircuit(Long id);
}
