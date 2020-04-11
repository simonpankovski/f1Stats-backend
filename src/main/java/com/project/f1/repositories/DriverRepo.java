package com.project.f1.repositories;

import com.project.f1.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepo extends CrudRepository<Driver,Long> {
    List<Driver> findAllByForename(String name);
    List<Driver> findAllBySurname(String surname);
    List<Driver> findAllByNationality(String nationality);
}
