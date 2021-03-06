package com.project.f1.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class ConstructorResults {
    @Id
    private Long id;
    @ManyToOne
    private Race race;
    @ManyToOne
    private Constructor constructor;
    private Float points;
    private String status;
}
