package com.project.f1.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Qualifying {
    @Id
    private Long id;
    @ManyToOne
    private Race race;
    @ManyToOne
    private Driver driver;
    @ManyToOne
    private Constructor constructor;
    private Integer number;
    private Integer position;
    private String q1;
    private String q2;
    private String q3;
}
