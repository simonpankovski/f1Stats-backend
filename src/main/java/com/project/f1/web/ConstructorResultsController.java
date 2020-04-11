package com.project.f1.web;

import com.project.f1.domain.ConstructorResults;
import com.project.f1.services.ConstructorResultsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/constructor_results")
public class ConstructorResultsController {
    private final ConstructorResultsServiceImpl constructorResultsService;
    @Autowired
    public ConstructorResultsController(ConstructorResultsServiceImpl constructorResultsService){
        this.constructorResultsService = constructorResultsService;
    }
    @GetMapping("/race/{id}")
    public List<ConstructorResults> getAllByRace(@PathVariable Long id){
        return constructorResultsService.getAllByRace(id);
    }
    @GetMapping("/constructor/{id}")
    public List<ConstructorResults> getAllByConstructor(@PathVariable Long id,@RequestParam(required = false) Integer year){
        if (year!=null){
            return constructorResultsService.getAllByYearAndConstructor(year,id);
        }
        return constructorResultsService.getAllByConstructor(id);
    }
    @GetMapping("/year/{year}")
    public List<ConstructorResults> getAllByYear(@PathVariable Integer year){
        return constructorResultsService.getAllByYear(year);
    }
    @GetMapping("/constructor_race")
    public List<ConstructorResults> getAllByConstructorAndRace(@RequestParam(required = false) Integer year, @RequestParam Long constructorId,@RequestParam Long raceId){
        if(year!=null) {
            return constructorResultsService.getAllByYearAndConstructorAndRace(year,constructorId, raceId);
        }
        else return constructorResultsService.getAllByConstructorAndRace(constructorId,raceId);

    }
}
