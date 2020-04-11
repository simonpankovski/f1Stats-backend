package com.project.f1.services;

import com.project.f1.domain.Driver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface DriverService {
    List<Driver> findDriversByName(String name);
    List<Driver> findDriversBySurname(String surname);
    Optional<Driver> findById(Long id);
    List<Driver> findDriversByNationality(String nationality);
    Iterable<Driver> getAllDrivers();

}
