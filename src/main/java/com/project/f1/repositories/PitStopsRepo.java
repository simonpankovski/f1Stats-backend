package com.project.f1.repositories;

import com.project.f1.domain.Driver;
import com.project.f1.domain.PitStops;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PitStopsRepo extends CrudRepository<PitStops,Long> {

    List<PitStops> findAllByStopEquals(Integer stop);
    List<PitStops> findAllByMillisecondsGreaterThanEqual(Integer milliseconds);
    List<PitStops> findAllByRaceId(Long id);
    List<PitStops> findAllByDriverId(Long id);
    List<PitStops> findAllByDriverIdAndRaceId(Long driverId, Long raceId);
    List<PitStops> findAllByDurationGreaterThanEqual(String duration);
}
