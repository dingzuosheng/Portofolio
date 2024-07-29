package com.ding.portofolio.controller;

import com.ding.portofolio.DTO.UserDto;
import com.ding.portofolio.DTO.UserLoginDto;
import com.ding.portofolio.model.Project;
import com.ding.portofolio.model.User;
import com.ding.portofolio.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<User> getMyUserInfo(@RequestBody UserLoginDto userLoginDto) throws Exception {
        User user = this.userService.getMyUserInfo(userLoginDto);
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserDto userDto) throws Exception {
        if(this.userService.register(userDto)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/{id}/projects")
    public ResponseEntity<Void> saveProject(@PathParam("id") Long id, Project project) throws Exception {
        this.userService.addProjectToUser(id, project);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/projects")
    public ResponseEntity<List<Project>> getAllProjects(@PathParam("id") Long id) throws Exception {
        List<Project> projects = this.userService.getAllProjects(id);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
}