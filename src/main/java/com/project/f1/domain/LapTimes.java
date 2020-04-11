package com.project.f1.domain;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.PrivateKey;
import java.sql.Time;

@Entity
@Getter
@Setter
public class LapTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Race race;
    @ManyToOne
    private Driver driver;
    private Integer lap;
    private Integer position;
    private String time;
    private Integer milliseconds;
}
