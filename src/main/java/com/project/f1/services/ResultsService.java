package com.project.f1.services;

import com.project.f1.domain.LapTimes;
import com.project.f1.domain.Results;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultsService {
    List<Results> getAllByRace(Long id);
    List<Results> getAllByDriver(Long id);
    List<Results> getAllByDriverAndRace(Long driverId,Long raceId);
    List<Results> getAllByDriverAndCircuit(Long driverId,Long circuitId);
    List<Results> getAllByCircuit(Long id);
    List<Results> getAllByCircuitIdAndStatusId(Long circuitId,Long statusId);
    List<Results> getAllByDriverIdAndStatusId(Long driverId,Long statusId);
    List<Results> getAllByDriverIdAndRace_Circuit_IdAndStatusId(Long driverId,Long circuitId,Long statusId);
    List<Results> getAllByDriverIdAndRaceIdAndStatusId(Long driverId,Long raceId,Long statusId);
    List<Results> getAllByCircuit_IdAndStatus(Long driverId,String status,String laps);
    List<Results> getAllByRace_Year(Integer year);
    List<Results> getAllResults();
    Results getFirstByRace_Circuit_Id(Long id);
    Integer getAllByCircuit_IdAndStatusCount(Long circuitId,String laps);
    Integer countAllByCircuit_Id(Long circuitId);
    List<Results> getAllByConstructorId(Long id);
    List<?> getResultsGroupBy();
    List<Results> getAllByCircuitIdOrderByMilliseconds(Long circuitId,String exclude);
}
