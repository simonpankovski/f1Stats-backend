package com.project.f1.web;

import com.project.f1.domain.Qualifying;
import com.project.f1.repositories.QualifyingRepo;
import com.project.f1.services.QualifyingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/qualifying")
public class QualifyingController {
    private final QualifyingServiceImpl qualifyingServiceImpl;
    @Autowired
    public QualifyingController(QualifyingServiceImpl qualifyingServiceImpl){
        this.qualifyingServiceImpl = qualifyingServiceImpl;
    }
    @GetMapping("/race/{id}")
    public List<Qualifying> getAllByRaceId(@PathVariable Long id) {
        return qualifyingServiceImpl.getAllByRaceId(id);
    }

    @GetMapping("/driver/{id}")
    public List<Qualifying> getAllByDriverId(@PathVariable Long id) {
        return qualifyingServiceImpl.getAllByDriverId(id);
    }

    @GetMapping("/race_driver")
    public List<Qualifying> getAllByRaceIdAndDriverId(@RequestParam Long raceId, @RequestParam Long driverId) {
        return qualifyingServiceImpl.getAllByRaceIdAndDriverId(raceId, driverId);
    }

    @GetMapping("/constructor/{id}")
    public List<Qualifying> getAllByConstructorId(@PathVariable Long id) {
        return qualifyingServiceImpl.getAllByConstructorId(id);
    }

    @GetMapping("/race_constructor")
    public List<Qualifying> getAllByRaceIdAndConstructorId(@RequestParam Long raceId,@RequestParam Long constructorId) {
        return qualifyingServiceImpl.getAllByRaceIdAndConstructorId(raceId, constructorId);
    }
    @GetMapping("/driver_circuit")
    public List<Qualifying> getAllByDriverIdAndCircuitId(@RequestParam Long driverId,@RequestParam Long circuitId) {
        return qualifyingServiceImpl.getAllByDriverIdAndRace_Circuit_Id(driverId, circuitId);
    }
    @GetMapping("/year/{year}")
    public List<Qualifying> getAllByRace_Year(@PathVariable Integer year) {
        return qualifyingServiceImpl.getAllByRace_Year(year);
    }

    @GetMapping("/circuit/{circuit}")
    public List<Qualifying> getAllByRace_Circuit(@PathVariable Long id) {
        return qualifyingServiceImpl.getAllByRace_Circuit(id);
    }
    @GetMapping("circuit_year")
    public List<Qualifying> getAllByRace_Circuit_idAndRace_year(@RequestParam Long circuitId,@RequestParam Integer year) {
        return qualifyingServiceImpl.getAllByRace_Circuit_IdAndRace_Year(circuitId, year);
    }
}
