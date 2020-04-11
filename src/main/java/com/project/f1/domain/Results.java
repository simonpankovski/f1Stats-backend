package com.project.f1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Results {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Race race;
    @ManyToOne
    private Driver driver;
    @ManyToOne
    private Constructor constructor;
    private String number;
    private Integer grid;
    private String position;
    private String positionOrder;
    private Float points;
    private Integer laps;
    private String time;
    private String milliseconds;
    private String fastestLap;
    private String speed;
    @ManyToOne
    private Status status;



}
