package com.project.f1.repositories;

import com.project.f1.domain.Circuit;
import com.project.f1.domain.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RaceRepo extends CrudRepository<Race,Long> {
    List<Race> findAllByYear(Integer year);
    List<Race> findByCircuitIdOrderByYear(Long id);
    List<Race> findAllByDate(String date);

}
