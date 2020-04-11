package com.project.f1.web;

import com.project.f1.domain.Driver;
import com.project.f1.domain.LapTimes;
import com.project.f1.domain.Race;
import com.project.f1.services.LapTimesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/lap_times")
public class LapTimesController {
    private final LapTimesServiceImpl lapTimesService;
    @Autowired
    public LapTimesController(LapTimesServiceImpl lapTimesService){
        this.lapTimesService = lapTimesService;
    }
    @GetMapping("/drivers/{id}")
    public List<LapTimes> getLapsByDriverId(@PathVariable Long id){
        return lapTimesService.getAllByDriver(id);
    }
    @GetMapping("/races/{id}")
    public List<LapTimes> getLapsByRaceId(@PathVariable Long id){
        return lapTimesService.getAllByRace(id);
    }
    @GetMapping("/driver_race")
    public List<LapTimes> getLapsByRaceAndDriver(@RequestParam Long driverId,@RequestParam Long raceId){
        return lapTimesService.getAllByDriverAndRace(driverId,raceId);
    }
    @GetMapping("/driver_circuit")
    public List<LapTimes> getLapsByDriverAndCircuit(@RequestParam Long driverId,@RequestParam Long circuitId){
        return lapTimesService.getAllByDriverAndCircuit(driverId,circuitId);
    }
    @GetMapping("/circuit/{id}")
    public List<LapTimes> getLapsByCircuit(@PathVariable Long id){
        return lapTimesService.getAllByCircuit(id);
    }
}
