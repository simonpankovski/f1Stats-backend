package com.project.f1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class DriverStandings {
    @Id
    private Long id;
    @ManyToOne
    private Race race;
    @ManyToOne
    private Driver driver;
    private Float points;
    private Integer position;
    private Integer won;
}
