package com.project.f1.services;

import com.project.f1.domain.ConstructorResults;

import java.util.List;

public interface ConstructorResultsService {
    List<ConstructorResults> getAllByRace(Long id);
    List<ConstructorResults> getAllByConstructor(Long id);
    List<ConstructorResults> getAllByConstructorAndRace(Long constructorId,Long raceId);
    List<ConstructorResults> getAllByYearAndConstructor(Integer year,Long id);
    List<ConstructorResults> getAllByYearAndConstructorAndRace(Integer year,Long constructorId,Long raceId);
    List<ConstructorResults> getAllByYear(Integer year);

}
