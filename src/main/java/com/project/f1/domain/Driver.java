package com.project.f1.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.security.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Driver {
    @Id
    private long id;
    private String driverRef;

    private String number;
    private String code;
    @NotBlank(message = "Name can't be blank!")
    private String forename;
    @NotBlank(message = "Surname can't be blank!")
    private String surname;
    @JsonFormat(pattern = "mm/dd/yyyy")
    private Date dob;
    private String nationality;
    private String url;
    public Driver(){}
}
