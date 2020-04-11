package com.project.f1.services;

import com.project.f1.domain.Qualifying;
import com.project.f1.repositories.QualifyingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QualifyingServiceImpl implements QualifyingService {
    @Autowired
    private QualifyingRepo qualifyingRepo;
    @Override
    public List<Qualifying> getAllByRaceId(Long id) {
        return qualifyingRepo.findAllByRaceId(id);
    }

    @Override
    public List<Qualifying> getAllByDriverId(Long id) {
        return qualifyingRepo.findAllByDriverId(id);
    }

    @Override
    public List<Qualifying> getAllByRaceIdAndDriverId(Long raceId, Long driverId) {
        return qualifyingRepo.findAllByRaceIdAndDriverId(raceId, driverId);
    }

    @Override
    public List<Qualifying> getAllByConstructorId(Long id) {
        return qualifyingRepo.findAllByConstructorId(id);
    }

    @Override
    public List<Qualifying> getAllByRaceIdAndConstructorId(Long raceId, Long constructorId) {
        return qualifyingRepo.findAllByRaceIdAndConstructorId(raceId, constructorId);
    }

    @Override
    public List<Qualifying> getAllByRace_Year(Integer year) {
        return qualifyingRepo.findAllByRace_Year(year);
    }

    @Override
    public List<Qualifying> getAllByRace_Circuit(Long id) {
        return qualifyingRepo.findAllByRace_Circuit_Id(id);
    }

    @Override
    public List<Qualifying> getAllByRace_Circuit_IdAndRace_Year(Long id, Integer year) {
        return qualifyingRepo.findAllByRace_Circuit_IdAndRace_Year(id,year);
    }

    @Override
    public List<Qualifying> getAllByDriverIdAndRace_Circuit_Id(Long id, Long circuitId) {
        return qualifyingRepo.findAllByDriverIdAndRace_Circuit_Id( id, circuitId);
    }
}
