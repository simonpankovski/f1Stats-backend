package com.project.f1.repositories;

import com.project.f1.domain.Constructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructorRepo extends CrudRepository<Constructor,Long> {

}
