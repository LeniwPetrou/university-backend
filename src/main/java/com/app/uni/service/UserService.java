package com.app.uni.service;

import com.app.uni.dto.UserDTO;
import java.util.List;

public interface UserService {

    public List<UserDTO> findAllUsers();
    public UserDTO addUser(UserDTO userDTO);
    public UserDTO findUserById(Long id);
    public UserDTO findUserByEmail(String email);
    public UserDTO updateUser(UserDTO userDTO);
    public UserDTO authenticateUser(String username, String password);
    public List<UserDTO> deleteUserById (List <UserDTO> usersDTO);
}
