package com.project.f1.repositories;

import com.project.f1.domain.Circuit;
import com.project.f1.domain.Race;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CircuitRepo extends CrudRepository<Circuit,Long> {

    Optional<Circuit> findById(Long id);
    Optional<Circuit> findByName(String name);
    List<Circuit> findAllByCountry(String country);
    List<Circuit> findByOrderByName();
}
