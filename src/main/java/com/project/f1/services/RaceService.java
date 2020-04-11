package com.project.f1.services;

import com.project.f1.domain.Race;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RaceService {
    List<Race> getAllRacesByYear(Integer year);
    List<Race> getAllRacesByCircuitId(Long id);
    List<Race> getAllRacesByDate(String date);
    Iterable<Race> getAllRaces();

}
