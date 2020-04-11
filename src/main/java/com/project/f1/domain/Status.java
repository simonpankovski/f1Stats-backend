package com.project.f1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Status {
    @Id
    private Long id;
    private String status;
}
