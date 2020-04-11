package com.project.f1.repositories;

import com.project.f1.domain.Results;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ResultsRepo extends PagingAndSortingRepository<Results,Long> {
    List<Results> findAllByRaceId(Long id);
    List<Results> findAllByDriverId(Long id);
    List<Results> findAllByConstructorId(Long id);
    List<Results> findAllByDriverIdAndRaceId(Long driverId,Long raceId);
    List<Results> findAllByRace_Year(Integer year);
    List<Results> findAllByDriverIdAndRace_Circuit_IdAndStatusId(Long driverId,Long circuitId,Long statusId);
    List<Results> findAllByDriverIdAndRaceIdAndStatusId(Long driverId,Long raceId,Long statusId);
    List<Results> findAllByDriverIdAndRace_Circuit_Id(Long driverId,Long circuitId);
    List<Results> findAllByRace_Circuit_Id(Long id);
    List<Results> findAllByRace_Circuit_IdAndStatusId(Long circuitId,Long statusId);
    List<Results> findAllByDriverIdAndStatusId(Long driverId,Long statusId);
    List<Results> findAllByRace_Circuit_IdAndStatus_StatusContainsOrStatus_StatusContains(Long driverId,String finished,String lap);
    List<Results> findAllByRace_Circuit_IdAndFastestLapIsNotContainingOrderByFastestLapAsc(Long circuitId, String exclude, Pageable page);

    @Query(value="select p.forename,p.surname,count(d) from Results d join Driver p on d.driver.id=p.id where d.position = '1' group by p.forename,p.surname")
    List<?> findResultsGroupBy();
    Integer countAllByRace_Circuit_IdAndStatus_StatusContains(Long driverId,String status);
    Results findFirstByRace_Circuit_Id(Long id);
    Integer countAllByRace_Circuit_Id(Long id);
    
}
