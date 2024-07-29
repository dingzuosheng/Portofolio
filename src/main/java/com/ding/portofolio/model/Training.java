package com.ding.portofolio.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Training {
    private Long id;
    private String title;
    private LocalDate date;
}
