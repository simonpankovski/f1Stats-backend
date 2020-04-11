package com.project.f1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
public class Race {
    @Id
    private long id;
    private int year;
    private int round;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "circuit_id")
    @JsonIgnore
    private Circuit circuit;
    private String date;
    private String time;
    private String url;
    public Race() {

    }
}

