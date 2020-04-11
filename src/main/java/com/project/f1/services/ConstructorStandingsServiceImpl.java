package com.project.f1.services;

import com.project.f1.domain.ConstructorStandings;
import com.project.f1.repositories.ConstructorStandingsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConstructorStandingsServiceImpl implements ConstructorStandingsService {
    @Autowired
    private ConstructorStandingsRepo constructorStandingsRepo;

    @Override
    public List<ConstructorStandings> getAllByRace(Long id) {
        return constructorStandingsRepo.findAllByRaceId(id);
    }

    @Override
    public List<ConstructorStandings> getAllByYearAndConstructor(Integer year, Long id) {
        return constructorStandingsRepo.findAllByRace_YearAndConstructorId(year,id);
    }

    @Override
    public List<ConstructorStandings> getAllByYearAndConstructorAndRace(Integer year, Long constructorId, Long raceId) {
        return constructorStandingsRepo.findAllByRace_YearAndConstructorIdAndRaceId(year, constructorId, raceId);
    }

    @Override
    public List<ConstructorStandings> getAllByYear(Integer year) {
        return constructorStandingsRepo.findAllByRace_Year(year);
    }

    @Override
    public List<ConstructorStandings> getAllByConstructor(Long id) {
        return constructorStandingsRepo.findAllByConstructorId(id);
    }

    @Override
    public List<ConstructorStandings> getAllByConstructorAndRace(Long constructorId, Long raceId) {
        return constructorStandingsRepo.findAllByConstructorIdAndRaceId(constructorId,raceId);
    }
}
