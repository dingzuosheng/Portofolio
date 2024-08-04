package com.ding.portofolio.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class TrainingDto {
    private Long id;
    private String title;
    private LocalDate date;
}
