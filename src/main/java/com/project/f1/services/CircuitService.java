package com.project.f1.services;

import com.project.f1.domain.Circuit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface CircuitService {
    Optional<Circuit> findCircuitByName(String name);
    Optional<Circuit> findCircuitById(Long id);
    List<Circuit> findAllCircuitsByCountry (String country);
    Iterable<Circuit> getAllCircuits();
}
