package com.project.f1.repositories;

import com.project.f1.domain.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepo extends CrudRepository<Status,Long> {
}
