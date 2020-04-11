package com.project.f1.repositories;

import com.project.f1.domain.Driver;
import com.project.f1.domain.LapTimes;
import com.project.f1.domain.Race;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LapTimesRepo extends CrudRepository<LapTimes,Long> {
    List<LapTimes> findAllByRaceId(Long id);
    List<LapTimes> findAllByDriverId(Long id);
    List<LapTimes> findAllByDriverIdAndRaceIdOrderByMilliseconds(Long driverId,Long raceId);
    List<LapTimes> findAllByDriverIdAndRace_Circuit_IdOrderByMilliseconds(Long driverId,Long circuitId);
    List<LapTimes> findAllByRace_Circuit_IdOrderByMilliseconds(Long circuitId);
}
