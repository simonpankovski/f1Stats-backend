package com.project.f1.web;

import com.project.f1.domain.PitStops;
import com.project.f1.repositories.PitStopsRepo;
import com.project.f1.services.PitStopsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/pit_stops")
public class PitStopsController {
    private final PitStopsServiceImpl pitStopsServiceImpl;
    @Autowired
    public PitStopsController(PitStopsServiceImpl pitStopsServiceImpl){
        this.pitStopsServiceImpl = pitStopsServiceImpl;
    }
    @GetMapping("/stops/{stop}")
    public List<PitStops> getAllByStopEquals(@PathVariable Integer stop) {
        return pitStopsServiceImpl.getAllByStopEquals(stop);
    }

    @GetMapping("/milliseconds/{milliseconds}")
    public List<PitStops> getAllByMillisecondsGreaterThanEqual(@PathVariable Integer milliseconds) {
        return pitStopsServiceImpl.getAllByMillisecondsGreaterThanEqual(milliseconds);
    }

    @GetMapping("/race/{id}")
    public List<PitStops> getAllByRaceId(@PathVariable Long id) {
        return pitStopsServiceImpl.getAllByRaceId(id);
    }

    @GetMapping("/driver/{id}")
    public List<PitStops> getAllByDriverId(@PathVariable Long id) {
        return pitStopsServiceImpl.getAllByDriverId(id);
    }

    @GetMapping("/driver_race")
    public List<PitStops> getAllByDriverIdAndRaceId(@RequestParam Long driverId, @RequestParam Long raceId) {
        return pitStopsServiceImpl.getAllByDriverIdAndRaceId(driverId, raceId);
    }

    @GetMapping("/duration/{duration}")
    public List<PitStops> getAllByDurationGreaterThanEqual(@PathVariable String duration) {
        return pitStopsServiceImpl.getAllByDurationGreaterThanEqual(duration);
    }
}
