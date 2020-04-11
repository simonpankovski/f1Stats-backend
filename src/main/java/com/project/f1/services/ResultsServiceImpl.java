package com.project.f1.services;

import com.project.f1.domain.Results;
import com.project.f1.repositories.ResultsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ResultsServiceImpl implements ResultsService {
    @Autowired
    private ResultsRepo resultsRepo;
    @Override
    public List<Results> getAllByRace(Long id) {
        return resultsRepo.findAllByRaceId(id);
    }

    @Override
    public List<Results> getAllByDriver(Long id) {
        return resultsRepo.findAllByDriverId(id);
    }

    @Override
    public List<Results> getAllByDriverAndRace(Long driverId, Long raceId) {
        return resultsRepo.findAllByDriverIdAndRaceId(driverId,raceId);
    }

    @Override
    public List<Results> getAllByDriverAndCircuit(Long driverId, Long circuitId) {
        return resultsRepo.findAllByDriverIdAndRace_Circuit_Id(driverId,circuitId);
    }

    @Override
    public List<Results> getAllByCircuitIdOrderByMilliseconds(Long circuitId,String exclude) {
        Pageable firstPageWithTenElements = PageRequest.of(0, 10);
        return resultsRepo.findAllByRace_Circuit_IdAndFastestLapIsNotContainingOrderByFastestLapAsc(circuitId,exclude,firstPageWithTenElements);
    }

    @Override
    public List<Results> getAllByCircuit(Long id) {
        return resultsRepo.findAllByRace_Circuit_Id(id);
    }

    @Override
    public List<Results> getAllByCircuitIdAndStatusId(Long circuitId, Long statusId) {
        return resultsRepo.findAllByRace_Circuit_IdAndStatusId(circuitId, statusId);
    }

    @Override
    public List<Results> getAllByDriverIdAndStatusId(Long driverId, Long statusId) {
        return resultsRepo.findAllByDriverIdAndStatusId(driverId, statusId);
    }

    @Override
    public List<Results> getAllByDriverIdAndRace_Circuit_IdAndStatusId(Long driverId, Long circuitId, Long statusId) {
        return resultsRepo.findAllByDriverIdAndRace_Circuit_IdAndStatusId(driverId, circuitId, statusId);
    }

    @Override
    public List<Results> getAllByDriverIdAndRaceIdAndStatusId(Long driverId, Long raceId, Long statusId) {
        return resultsRepo.findAllByDriverIdAndRaceIdAndStatusId(driverId, raceId, statusId);
    }

    @Override
    public List<Results> getAllByCircuit_IdAndStatus(Long circuitId, String finished,String laps) {
        return resultsRepo.findAllByRace_Circuit_IdAndStatus_StatusContainsOrStatus_StatusContains(circuitId,finished,laps);
    }

    @Override
    public Integer getAllByCircuit_IdAndStatusCount(Long circuitId, String laps) {
        return  resultsRepo.countAllByRace_Circuit_IdAndStatus_StatusContains(circuitId,laps);
    }

    @Override
    public List<Results> getAllByRace_Year(Integer year) {
        return resultsRepo.findAllByRace_Year(year);
    }

    @Override
    public List<Results> getAllResults() {
        return (List<Results>) resultsRepo.findAll();
    }

    @Override
    public Results getFirstByRace_Circuit_Id(Long id) {
        return resultsRepo.findFirstByRace_Circuit_Id(id);
    }

    @java.lang.Override
    public List<?> getResultsGroupBy() {
        return resultsRepo.findResultsGroupBy();
    }

    @Override
    public List<Results> getAllByConstructorId(Long id) {
        return resultsRepo.findAllByConstructorId(id);
    }

    @Override
    public Integer countAllByCircuit_Id(Long circuitId) {
        return resultsRepo.countAllByRace_Circuit_Id(circuitId);
    }
}
