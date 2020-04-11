package com.project.f1.services;

import com.project.f1.domain.DriverStandings;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DriverStandingsService {
    List<DriverStandings> getAll();
    List<DriverStandings> getAllByRaceId(Long id);
    List<DriverStandings> getAllByDriverId(Long id);
    List<DriverStandings> getAllByPoints(Float id);
    List<DriverStandings> getAllByRaceYear(Integer year);

}
