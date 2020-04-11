package com.project.f1.web;

import com.project.f1.domain.Circuit;
import com.project.f1.domain.Results;
import com.project.f1.services.CircuitServiceImpl;
import com.project.f1.services.ResultsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/results")
public class ResultsController {
    private final ResultsServiceImpl resultsService;

    private final RestTemplate restTemplate=new RestTemplate();
    @Autowired
    public ResultsController(ResultsServiceImpl resultsService) {
        this.resultsService = resultsService;

    }
    @GetMapping("/image/{id}")
    public String getWikiPlainJSON(@PathVariable String id){


        String url = "https://en.wikipedia.org/w/api.php?action=parse&format=json&page="+id+"+&prop=text&formatversion=2";
        return this.restTemplate.getForObject(url, String.class);
    }
    @GetMapping("/drivers")
    public List<Results> getResultsByDriverId(@RequestParam Long driverId, @RequestParam(required = false) Long statusId, @RequestParam(required = false) String status) {

        if (statusId == null) {
            return resultsService.getAllByDriver(driverId);
        }
        return resultsService.getAllByDriverIdAndStatusId(driverId, statusId);
    }
    @GetMapping("/group")
    public List<?> getResultsGroupBy(){
        return resultsService.getResultsGroupBy();
    }
    @GetMapping("/constructors")
    public List<Results> getResultsByConstructorId(@RequestParam Long constructorId){
        return resultsService.getAllByConstructorId(constructorId);
    }
    @GetMapping("/races/all")
    public List<Results> getAllResults() {
        return resultsService.getAllResults();
    }
    @GetMapping("/races/{id}")
    public List<Results> getResultsByRaceId(@PathVariable Long id) {
        return resultsService.getAllByRace(id);
    }
    @GetMapping("/year/{year}")
    public List<Results> getResultsByYear(@PathVariable Integer year){
        return resultsService.getAllByRace_Year(year);
    }
    @GetMapping("/driver_race")
    public List<Results> getResultsByRaceAndDriver(@RequestParam Long driverId, @RequestParam Long raceId, @RequestParam(required = false) Long statusId) {
        if (statusId == null)
            return resultsService.getAllByDriverAndRace(driverId, raceId);
        return resultsService.getAllByDriverIdAndRaceIdAndStatusId(driverId, raceId, statusId);
    }

    @GetMapping("/driver_circuit")
    public List<Results> getResultsByDriverAndCircuit(@RequestParam Long driverId, @RequestParam Long circuitId, @RequestParam(required = false) Long statusId) {
        if (statusId == null)
            return resultsService.getAllByDriverAndCircuit(driverId, circuitId);
        return resultsService.getAllByDriverIdAndRace_Circuit_IdAndStatusId(driverId, circuitId, statusId);
    }

    @GetMapping("/circuit_laps/{id}")
    public List<Results> getResultsByCircuitOrderByMilliseconds(@PathVariable Long id) {
        return resultsService.getAllByCircuitIdOrderByMilliseconds(id, "N");
    }

    @GetMapping("/circuit")
    public List<Results> getResultsByCircuit(@RequestParam Long circuitId, @RequestParam(required = false) Long statusId, @RequestParam(required = false) String status) {
        if (statusId == null) {
            if (status == null) {
                return resultsService.getAllByCircuit(circuitId);
            } else {
                return resultsService.getAllByCircuit_IdAndStatus(circuitId, "Finished", "Lap");
            }

        }
        return resultsService.getAllByCircuitIdAndStatusId(circuitId, statusId);


    }

    @GetMapping("/circuit/{circuitId}/{status}")
    public int getResultsByCircuitStatus(@PathVariable Long circuitId, @PathVariable String status) {
        return resultsService.getAllByCircuit_IdAndStatusCount(circuitId, "Lap") + resultsService.getAllByCircuit_IdAndStatusCount(circuitId,"Finished");
    }
    @GetMapping("/circuit/count_all/{circuitId}")
    public int getResultsByCircuitCountAll(@PathVariable Long circuitId) {
        return resultsService.countAllByCircuit_Id(circuitId);
    }



}
