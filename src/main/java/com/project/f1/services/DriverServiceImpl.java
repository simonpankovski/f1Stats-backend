package com.project.f1.services;

import com.project.f1.domain.Driver;
import com.project.f1.repositories.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
    private DriverRepo driverRepo;
    public Driver saveOrUpdate(Driver driver){
        return driverRepo.save(driver);
    }
    public List<Driver> findDriversByName(String name){
        return driverRepo.findAllByForename(name);
    }

    @Override
    public List<Driver> findDriversBySurname(String surname) {
        return driverRepo.findAllBySurname(surname);
    }

    @Override
    public Optional<Driver> findById(Long id) {
        return driverRepo.findById(id);
    }

    @Override
    public List<Driver> findDriversByNationality(String nationality) {
        return driverRepo.findAllByNationality(nationality);
    }

    @Override
    public Iterable<Driver> getAllDrivers() {
        return driverRepo.findAll();
    }


}
