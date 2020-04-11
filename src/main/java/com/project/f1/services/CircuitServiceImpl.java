package com.project.f1.services;

import com.project.f1.domain.Circuit;
import com.project.f1.repositories.CircuitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CircuitServiceImpl implements CircuitService {

    @Autowired
    private CircuitRepo circuitRepo;

    @Override
    public Optional<Circuit> findCircuitByName(String name) {
        return circuitRepo.findByName(name);
    }

    @Override
    public Optional<Circuit> findCircuitById(Long id) {
        return circuitRepo.findById(id);
    }

    @Override
    public List<Circuit> findAllCircuitsByCountry(String country) {
        return circuitRepo.findAllByCountry(country);
    }

    @Override
    public Iterable<Circuit> getAllCircuits() {
        return circuitRepo.findByOrderByName();
    }
}
