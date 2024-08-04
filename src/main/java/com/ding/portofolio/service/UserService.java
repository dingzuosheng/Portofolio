package com.ding.portofolio.service;


import com.ding.portofolio.DTO.ProjectDto;
import com.ding.portofolio.DTO.UserDto;
import com.ding.portofolio.DTO.UserLoginDto;
import com.ding.portofolio.exception.*;
import com.ding.portofolio.mapper.ProjectMapper;
import com.ding.portofolio.model.Project;
import com.ding.portofolio.model.User;
import com.ding.portofolio.repository.ProjectRepository;
import com.ding.portofolio.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper = new ProjectMapper();

    public UserService(UserRepository userRepository,
                       ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    public User getMyUserInfo(Long id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public void register(UserDto userDto) {
        Optional<User> optionalUser = this.userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()) {
            throw new UserAlreadyExistException("This user has already registered");
        }
        User user = UserDto.convert(userDto);
        this.userRepository.save(user);
    }

    public User login(UserLoginDto userLoginDto) {
        if(userLoginDto == null) {
            throw new LoginException("Please give your email and password");
        }
        Optional<User> optionalUser = this.userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
        return optionalUser.orElse(null);
    }

    public void addProjectToUser(Long id, ProjectDto projectDto) throws UserNotValidException, ProjectNotValidException, UserNotExistException {
        if(id == null) {
            throw new UserNotValidException("User is not valid");
        }
        if(projectDto == null) {
            throw new ProjectNotValidException("Project is no valid");
        }

        Optional<User> optionalUser = this.userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new UserNotExistException("This User doesn't exist");
        }

        User user = optionalUser.get();

        Project project = this.projectMapper.DtoToMapper(projectDto);
        this.projectRepository.save(project);
        user.addProject(project);
        Optional<Project> optionalProject = this.projectRepository.findById(project.getId());
        if(optionalProject.isPresent()) {
            this.userRepository.save(user);
        }
    }

    public List<Project> getAllProjects(Long userId) throws UserNotExistException {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        if(optionalUser.isEmpty()) {
            throw new UserNotExistException("This user doesn't exist");
        }

        User user = optionalUser.get();
        return user.getProjects();
    }
}
