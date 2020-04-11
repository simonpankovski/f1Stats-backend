package com.project.f1.web;

import com.project.f1.domain.Constructor;
import com.project.f1.services.ConstructorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/constructors")
public class ConstructorController {
    private final ConstructorServiceImpl constructorService;
    @Autowired
    public ConstructorController(ConstructorServiceImpl constructorService){
        this.constructorService = constructorService;
    }
    @GetMapping("/all")
    public List<Constructor> getAll(){
        return constructorService.getAll();
    }
}
