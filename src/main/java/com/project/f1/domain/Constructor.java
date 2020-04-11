package com.project.f1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Constructor {
    @Id
    private Long id;
    private String constructorRef;
    private String name;
    private String nationality;
    private String url;
}
