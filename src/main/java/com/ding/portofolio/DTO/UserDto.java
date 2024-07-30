package com.ding.portofolio.DTO;

import com.ding.portofolio.model.*;

public class UserDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String occupation;
    private Role role;
    private ProjectData projectData;
    private TrainingData trainingData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ProjectData getProjectData() {
        return projectData;
    }

    public void setProjectData(ProjectData projectData) {
        this.projectData = projectData;
    }

    public TrainingData getTrainingData() {
        return trainingData;
    }

    public void setTrainingData(TrainingData trainingData) {
        this.trainingData = trainingData;
    }

    public static User convert(final UserDto userDto) {
        if(userDto == null) {
            return null;
        }
        final User user = new User();
        user.setId(userDto.getId());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setOccupation(userDto.getOccupation());
        user.setProjectData(userDto.getProjectData());
        user.setTrainingData(userDto.getTrainingData());

        return user;
    }

    public static UserDto convert(final User user) {
        if(user == null) {
            return null;
        }

        final UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setOccupation(user.getOccupation());
        userDto.setRole(user.getRole());
        userDto.setProjectData(user.getProjectData());
        userDto.setTrainingData(user.getTrainingData());

        return userDto;
    }

}
