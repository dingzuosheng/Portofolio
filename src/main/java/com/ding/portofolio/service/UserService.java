package com.ding.portofolio.service;


import com.ding.portofolio.DTO.ProjectDto;
import com.ding.portofolio.DTO.TrainingDto;
import com.ding.portofolio.DTO.UserDto;
import com.ding.portofolio.DTO.UserLoginDto;
import com.ding.portofolio.exception.*;
import com.ding.portofolio.mapper.ProjectMapper;
import com.ding.portofolio.mapper.TrainingMapper;
import com.ding.portofolio.model.Project;
import com.ding.portofolio.model.Training;
import com.ding.portofolio.model.User;
import com.ding.portofolio.repository.ProjectRepository;
import com.ding.portofolio.repository.TrainingRepository;
import com.ding.portofolio.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final TrainingRepository trainingRepository;
    private final ProjectMapper projectMapper = new ProjectMapper();
    private final TrainingMapper trainingMapper = new TrainingMapper();

    public UserService(UserRepository userRepository,
                       ProjectRepository projectRepository,
                       TrainingRepository trainingRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.trainingRepository = trainingRepository;
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

    public void addTrainingToUser(Long id, TrainingDto trainingDto) {
        if(id == null) {
            throw new UserNotValidException("User is not valid");
        }
        if(trainingDto == null) {
            throw new TrainingNotValidException("Training is no valid");
        }

        Optional<User> optionalUser = this.userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new UserNotExistException("This User doesn't exist");
        }

        User user = optionalUser.get();

        Training training = this.trainingMapper.dtoToMapper(trainingDto);
        this.trainingRepository.save(training);
        user.addTraining(training);
        Optional<Training> optionalTraining = this.trainingRepository.findById(training.getId());
        if(optionalTraining.isPresent()) {
            this.userRepository.save(user);
        }
    }

    public List<Training> getAllTrainings(Long userId) throws UserNotExistException {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        if(optionalUser.isEmpty()) {
            throw new UserNotExistException("This user doesn't exist");
        }

        User user = optionalUser.get();
        return user.getTrainings();
    }
}
