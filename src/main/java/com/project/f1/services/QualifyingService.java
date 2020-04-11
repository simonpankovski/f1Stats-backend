package com.project.f1.services;

import com.project.f1.domain.Qualifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QualifyingService {
    List<Qualifying> getAllByRaceId(Long id);
    List<Qualifying> getAllByDriverId(Long id);
    List<Qualifying> getAllByRaceIdAndDriverId(Long raceId,Long driverId);
    List<Qualifying> getAllByConstructorId(Long id);
    List<Qualifying> getAllByRaceIdAndConstructorId(Long raceId,Long constructorId);
    List<Qualifying> getAllByRace_Year(Integer year);
    List<Qualifying> getAllByRace_Circuit(Long id);
    List<Qualifying> getAllByRace_Circuit_IdAndRace_Year(Long id, Integer year);
    List<Qualifying> getAllByDriverIdAndRace_Circuit_Id(Long id, Long circuitId);
}
