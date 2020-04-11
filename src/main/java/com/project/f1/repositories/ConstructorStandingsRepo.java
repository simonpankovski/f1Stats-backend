package com.project.f1.repositories;

import com.project.f1.domain.ConstructorResults;
import com.project.f1.domain.ConstructorStandings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConstructorStandingsRepo extends CrudRepository<ConstructorStandings,Long> {
    List<ConstructorStandings> findAllByRaceId(Long id);
    List<ConstructorStandings> findAllByConstructorId(Long id);
    List<ConstructorStandings> findAllByConstructorIdAndRaceId(Long constructorId,Long raceId);
    List<ConstructorStandings> findAllByRace_Year(Integer year);
    List<ConstructorStandings> findAllByRace_YearAndConstructorId(Integer year,Long id);
    List<ConstructorStandings> findAllByRace_YearAndConstructorIdAndRaceId(Integer year,Long constructorId,Long raceId);
}
