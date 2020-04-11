package com.project.f1.services;

import com.project.f1.domain.Constructor;
import com.project.f1.repositories.ConstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConstructorServiceImpl implements ConstructorService {
    @Autowired
    private ConstructorRepo constructorRepo;

    @java.lang.Override
    public java.util.Optional<Constructor> getById(Long id) {
        return constructorRepo.findById(id);
    }

    @Override
    public List<Constructor> getAll() {
        return (List<Constructor>) constructorRepo.findAll();
    }
}
