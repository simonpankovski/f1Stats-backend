package com.project.f1.web;

import com.project.f1.domain.Circuit;
import com.project.f1.domain.Race;
import com.project.f1.services.RaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/races")
public class RaceController {
    private final RaceServiceImpl raceService;
    @Autowired
    public RaceController(RaceServiceImpl raceService){
        this.raceService=raceService;
    }
    @GetMapping("")
    public List<Race> getAll(){
        return (List<Race>) raceService.getAllRaces();
    }
    @GetMapping("/circuits/{id}")
    public List<Race> getAllById(@PathVariable Long id){
        return raceService.getAllRacesByCircuitId(id);
    }
    @GetMapping("/year/{year}")
    public List<Race> getAllByYear(@PathVariable Integer year){
        return raceService.getAllRacesByYear(year);
    }

    @GetMapping("/date/{date}")
    public List<Race> getAllByDate(@PathVariable String date){
        String tmp =String.join("/",date.split("-"));
        return raceService.getAllRacesByDate(tmp);
    }
}
