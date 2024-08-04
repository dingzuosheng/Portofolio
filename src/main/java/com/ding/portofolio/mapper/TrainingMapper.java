package com.ding.portofolio.mapper;

import com.ding.portofolio.DTO.TrainingDto;
import com.ding.portofolio.model.Training;
import org.modelmapper.ModelMapper;

public class TrainingMapper extends ModelMapper {
    public Training dtoToMapper(TrainingDto trainingDto) {
        if(trainingDto == null) {
            return null;
        }

        Training training = new Training();
        training.setTitle(trainingDto.getTitle());
        training.setDate(trainingDto.getDate());

        return training;
    }
}
