package com.ding.portofolio.mapper;

import com.ding.portofolio.DTO.ProjectDto;
import com.ding.portofolio.model.Project;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProjectMapper extends ObjectMapper {

    public Project DtoToMapper(ProjectDto projectDto) {
        if(projectDto == null) {
            return null;
        }
        Project project = new Project();
        project.setTitle(projectDto.getTitle());
        project.setDescription(projectDto.getDescription());
        project.setStartDate(projectDto.getStartDate());
        project.setEndDate(projectDto.getEndDate());
        project.setImageUrl(projectDto.getImageUrl());

        return project;
    }
}
