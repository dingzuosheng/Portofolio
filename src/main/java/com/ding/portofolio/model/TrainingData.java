package com.ding.portofolio.model;

import java.io.Serializable;
import java.util.List;

public class TrainingData implements Serializable {
    private List<Training> trainings;

    public TrainingData(List<Training> trainings) {
        this.trainings = trainings;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }
}
