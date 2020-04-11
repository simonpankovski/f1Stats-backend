package com.project.f1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Circuit {
    @Id
    private long id;
    private String circuitRef;
    private String name;
    private String location;
    private String country;
    private String url;
}
