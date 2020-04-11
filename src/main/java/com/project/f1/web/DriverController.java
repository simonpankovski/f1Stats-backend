package com.project.f1.web;

import com.project.f1.domain.Driver;
import com.project.f1.services.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverServiceImpl driverServiceImpl;
    @Autowired
    public DriverController(DriverServiceImpl driverServiceImpl){
        this.driverServiceImpl = driverServiceImpl;
    }

    @PostMapping("")
    public ResponseEntity<Driver> createNewDriver(@Valid @RequestBody Driver driver){
        Driver d = driverServiceImpl.saveOrUpdate(driver);
        return new ResponseEntity<Driver>(d, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public List<Driver> getAll(){
        return (List<Driver>) driverServiceImpl.getAllDrivers();
    }
    @GetMapping("/name/{name}")
    public List<Driver> getDriverByName(@PathVariable String name){
        List<Driver> driver = driverServiceImpl.findDriversByName(name);
        return driver;
    }
    @GetMapping("/nationality/{nationality}")
    public Iterable<Driver> getDriversByNationality(@PathVariable String nationality){
        List<Driver> driver = driverServiceImpl.findDriversByNationality(nationality);
        return driver;
    }
}
