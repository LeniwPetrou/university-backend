package com.app.uni.controller;


import com.app.uni.dto.UserDTO;
import com.app.uni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/findAllUsers")
    public List<UserDTO> findAllUsers() {
        return userService.findAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addUser")
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @GetMapping("/findUserById/{id}")
    public UserDTO findUserById (@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping("/findUserByEmail/{email}")
    public UserDTO findUserByEmail (@PathVariable String email){
        return userService.findUserByEmail(email);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/delete")
    public List<UserDTO> deleteStudentById (@RequestBody List <UserDTO> userDTOS){
        return userService.deleteUserById(userDTOS);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateUser")
    public UserDTO updateUser (@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/authenticateUser/{username}/{password}")
    public UserDTO authenticateUser(@PathVariable String username, @PathVariable String password) {
        return userService.authenticateUser(username, password);
    }
}