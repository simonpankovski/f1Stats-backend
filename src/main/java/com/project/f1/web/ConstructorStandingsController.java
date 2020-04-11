package com.project.f1.web;

import com.project.f1.domain.ConstructorStandings;
import com.project.f1.services.ConstructorStandingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/constructor_standings")
public class ConstructorStandingsController {
    private final ConstructorStandingsServiceImpl constructorStandingsServiceImpl;
    @Autowired
    public ConstructorStandingsController(ConstructorStandingsServiceImpl constructorStandingsServiceImpl){
        this.constructorStandingsServiceImpl = constructorStandingsServiceImpl;
    }
    @GetMapping("/race/{id}")
    public List<ConstructorStandings> getAllByRace(@PathVariable Long id){
        return constructorStandingsServiceImpl.getAllByRace(id);
    }
    @GetMapping("/constructor/{id}")
    public List<ConstructorStandings> getAllByConstructor(@PathVariable Long id,@RequestParam(required = false) Integer year){
        if (year!=null){
            return constructorStandingsServiceImpl.getAllByYearAndConstructor(year,id);
        }
        return constructorStandingsServiceImpl.getAllByConstructor(id);
    }
    @GetMapping("/year/{year}")
    public List<ConstructorStandings> getAllByYear(@PathVariable Integer year){
        return constructorStandingsServiceImpl.getAllByYear(year);
    }
    @GetMapping("/constructor_race")
    public List<ConstructorStandings> getAllByConstructorAndRace(@RequestParam(required = false) Integer year, @RequestParam Long constructorId,@RequestParam Long raceId){
        if(year!=null) {
            return constructorStandingsServiceImpl.getAllByYearAndConstructorAndRace(year,constructorId, raceId);
        }
        else return constructorStandingsServiceImpl.getAllByConstructorAndRace(constructorId,raceId);

    }
}
