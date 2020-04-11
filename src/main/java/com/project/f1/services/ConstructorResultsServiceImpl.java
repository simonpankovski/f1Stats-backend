package com.project.f1.services;

import com.project.f1.domain.Circuit;
import com.project.f1.domain.ConstructorResults;
import com.project.f1.repositories.ConstructorResultsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ConstructorResultsServiceImpl implements ConstructorResultsService{
    @Autowired
    private ConstructorResultsRepo constructorResultsRepo;

    @Override
    public List<ConstructorResults> getAllByRace(Long id) {
        return constructorResultsRepo.findAllByRaceId(id);
    }

    @Override
    public List<ConstructorResults> getAllByYearAndConstructor(Integer year, Long id) {
        return constructorResultsRepo.findAllByRace_YearAndConstructorId(year,id);
    }

    @Override
    public List<ConstructorResults> getAllByYearAndConstructorAndRace(Integer year, Long constructorId, Long raceId) {
        return constructorResultsRepo.findAllByRace_YearAndConstructorIdAndRaceId(year, constructorId, raceId);
    }

    @Override
    public List<ConstructorResults> getAllByYear(Integer year) {
        return constructorResultsRepo.findAllByRace_Year(year);
    }

    @Override
    public List<ConstructorResults> getAllByConstructor(Long id) {
        return constructorResultsRepo.findAllByConstructorId(id);
    }

    @Override
    public List<ConstructorResults> getAllByConstructorAndRace(Long constructorId, Long raceId) {
        return constructorResultsRepo.findAllByConstructorIdAndRaceId(constructorId,raceId);
    }
}
