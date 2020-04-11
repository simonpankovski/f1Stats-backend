package com.project.f1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class PitStops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Race race;
    @ManyToOne
    private Driver driver;
    private Integer stop;
    private Integer lap;
    private String time;
    private String duration;
    private Integer milliseconds;
    public PitStops(){}


}
