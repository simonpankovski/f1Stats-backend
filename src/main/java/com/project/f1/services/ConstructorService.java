package com.project.f1.services;

import com.project.f1.domain.Constructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ConstructorService {
    List<Constructor> getAll();
    java.util.Optional<Constructor> getById(Long id);
}
