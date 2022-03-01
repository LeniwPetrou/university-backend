package com.app.uni.dto;

import com.app.uni.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private List<CourseDTO> courseDTO;
    private Long roleId;

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roleId = user.getRole_id();
    }
}
