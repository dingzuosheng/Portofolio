package com.ding.portofolio.controller;

import com.ding.portofolio.DTO.ProjectDto;
import com.ding.portofolio.DTO.TrainingDto;
import com.ding.portofolio.DTO.UserDto;
import com.ding.portofolio.exception.ProjectNotValidException;
import com.ding.portofolio.exception.UserNotExistException;
import com.ding.portofolio.exception.UserNotValidException;
import com.ding.portofolio.model.Project;
import com.ding.portofolio.model.Training;
import com.ding.portofolio.model.User;
import com.ding.portofolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserInfo(@PathVariable("id") Long id) throws UserNotExistException {
        User user = this.userService.getMyUserInfo(id);
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        throw new UserNotExistException("User not found");
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserDto userDto) {
        this.userService.register(userDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/projects")
    public ResponseEntity<Void> saveProject(@PathVariable("id") Long id, @RequestBody ProjectDto project) throws UserNotValidException, ProjectNotValidException, UserNotExistException {
        this.userService.addProjectToUser(id, project);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/projects")
    public ResponseEntity<List<Project>> getAllProjects(@PathVariable("id") Long id) {
        List<Project> projects = this.userService.getAllProjects(id);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping("/{id}/trainings")
    public ResponseEntity<Void> saveTraining(@PathVariable("id") Long id, @RequestBody TrainingDto training) {
        this.userService.addTrainingToUser(id, training);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/trainings")
    public ResponseEntity<List<Training>> getAllTrainings(@PathVariable("id")Long id) {
        List<Training> trainings = this.userService.getAllTrainings(id);
        return new ResponseEntity<>(trainings, HttpStatus.OK);
    }
}
