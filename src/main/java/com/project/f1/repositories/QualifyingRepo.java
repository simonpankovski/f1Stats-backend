package com.project.f1.repositories;

import com.project.f1.domain.Qualifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QualifyingRepo extends CrudRepository<Qualifying,Long> {
    List<Qualifying> findAllByRaceId(Long id);
    List<Qualifying> findAllByDriverId(Long id);
    List<Qualifying> findAllByRaceIdAndDriverId(Long raceId,Long driverId);
    List<Qualifying> findAllByConstructorId(Long id);
    List<Qualifying> findAllByRaceIdAndConstructorId(Long raceId,Long constructorId);
    List<Qualifying> findAllByRace_Year(Integer year);
    List<Qualifying> findAllByRace_Circuit_IdAndRace_Year(Long id, Integer year);
    List<Qualifying> findAllByRace_Circuit_Id(Long id);
    List<Qualifying> findAllByDriverIdAndRace_Circuit_Id(Long id, Long circuitId);

}
