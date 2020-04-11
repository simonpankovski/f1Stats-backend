package com.project.f1.services;

import com.project.f1.domain.ConstructorResults;
import com.project.f1.domain.ConstructorStandings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConstructorStandingsService {
    List<ConstructorStandings> getAllByRace(Long id);
    List<ConstructorStandings> getAllByConstructor(Long id);
    List<ConstructorStandings> getAllByConstructorAndRace(Long constructorId,Long raceId);
    List<ConstructorStandings> getAllByYearAndConstructor(Integer year,Long id);
    List<ConstructorStandings> getAllByYearAndConstructorAndRace(Integer year,Long constructorId,Long raceId);
    List<ConstructorStandings> getAllByYear(Integer year);
}
