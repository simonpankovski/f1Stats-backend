package com.project.f1.repositories;

import com.project.f1.domain.ConstructorResults;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConstructorResultsRepo extends CrudRepository<ConstructorResults,Long> {
    List<ConstructorResults> findAllByRaceId(Long id);
    List<ConstructorResults> findAllByConstructorId(Long id);
    List<ConstructorResults> findAllByConstructorIdAndRaceId(Long constructorId,Long raceId);
    List<ConstructorResults> findAllByRace_Year(Integer year);
    List<ConstructorResults> findAllByRace_YearAndConstructorId(Integer year,Long id);
    List<ConstructorResults> findAllByRace_YearAndConstructorIdAndRaceId(Integer year,Long constructorId,Long raceId);

}
