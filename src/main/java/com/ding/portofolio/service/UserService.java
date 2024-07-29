package com.ding.portofolio.service;


import com.ding.portofolio.DTO.UserDto;
import com.ding.portofolio.DTO.UserLoginDto;
import com.ding.portofolio.model.Project;
import com.ding.portofolio.model.ProjectData;
import com.ding.portofolio.model.User;
import com.ding.portofolio.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getMyUserInfo(UserLoginDto userLoginDto) throws Exception {
        User loginedUser = this.login(userLoginDto);
        if(loginedUser == null) {
            throw new Exception("Login data is not correct");
        }
        return null;
    }

    public Boolean register(UserDto userDto) throws Exception {
        Optional<User> optionalUser = this.userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isEmpty()) {
            User user = optionalUser.get();
            this.userRepository.save(user);
            return true;
        }
        return false;
    }

    public User login(UserLoginDto userLoginDto) throws Exception {
        if(userLoginDto == null) {
            throw new Exception("Please give your email and password");
        }
        Optional<User> optionalUser = this.userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
        return optionalUser.orElse(null);
    }

    public void addProjectToUser(Long id, Project project) throws Exception {
        if(id == null) {
            throw new Exception("User is not valid");
        }
        if(project == null) {
            throw new Exception("Project is no valid");
        }

        Optional<User> optionalUser = this.userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new Exception("This User doesn't exist");
        }
        User user = optionalUser.get();


        ProjectData projectData = user.getProjectData();
        List<Project> projects = projectData.getProjects();
        projects.add(project);
        projectData.setProjects(projects);
        user.setProjectData(projectData);
        this.userRepository.save(user);
    }

    public List<Project> getAllProjects(Long userId) throws Exception {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        if(optionalUser.isEmpty()) {
            throw new Exception("This user doesn't exist");
        }

        User user = optionalUser.get();
        return user.getProjectData().getProjects();
    }


}
