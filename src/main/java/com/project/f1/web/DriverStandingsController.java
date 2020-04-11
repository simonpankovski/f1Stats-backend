package com.project.f1.web;

import com.project.f1.domain.DriverStandings;
import com.project.f1.services.DriverStandingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/driver_standings")
public class DriverStandingsController {
    private final DriverStandingsServiceImpl driverStandingsService;
    @Autowired
    public DriverStandingsController(DriverStandingsServiceImpl driverStandingsService){
        this.driverStandingsService = driverStandingsService;
    }
    @GetMapping("")
    public List<DriverStandings> getAll(){
        return driverStandingsService.getAll();
    }
    @GetMapping("/race_id/{id}")
    public List<DriverStandings> getAllByRace(@PathVariable Long id){
        return driverStandingsService.getAllByRaceId(id);
    }
    @GetMapping("/driver_id/{id}")
    public List<DriverStandings> getAllByDriver(@PathVariable Long id){
        return driverStandingsService.getAllByDriverId(id);
    }
    @GetMapping("/race_year/{year}")
    public List<DriverStandings> getAllByRaceYear(@PathVariable Integer year){
        return driverStandingsService.getAllByRaceYear(year);
    }
}
