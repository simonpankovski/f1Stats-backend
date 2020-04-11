package com.project.f1.web;

import com.project.f1.domain.Circuit;
import com.project.f1.services.CircuitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/circuits")
public class CircuitController {

    private final CircuitServiceImpl circuitServiceImpl;
    @Autowired
    public CircuitController(CircuitServiceImpl circuitServiceImpl){
        this.circuitServiceImpl = circuitServiceImpl;
    }
    @GetMapping("")
    public List<Circuit> getAll(){
        return (List<Circuit>) circuitServiceImpl.getAllCircuits();
    }
    @GetMapping("/name/{name}")
    public Optional<Circuit> getByName(@PathVariable String name){
        return circuitServiceImpl.findCircuitByName(name);
    }
    @GetMapping("/country/{country}")
    public List<Circuit> getByCountry(@PathVariable String country){
        return circuitServiceImpl.findAllCircuitsByCountry(country);
    }

}
