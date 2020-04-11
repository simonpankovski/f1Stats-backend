package com.project.f1.repositories;

import com.project.f1.domain.DriverStandings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverStandingsRepo extends CrudRepository<DriverStandings,Long> {
    List<DriverStandings> findAllByDriverId(Long id);
    List<DriverStandings> findAllByRaceIdOrderByPosition(Long id);
    List<DriverStandings> findAllByPoints(Float points);
    List<DriverStandings> findAllByRace_Year(Integer year);

}
