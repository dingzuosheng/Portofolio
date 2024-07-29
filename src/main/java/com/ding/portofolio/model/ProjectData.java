package com.ding.portofolio.model;

import java.io.Serializable;
import java.util.List;

public class ProjectData implements Serializable {
    private List<Project> projects;

    public ProjectData(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
