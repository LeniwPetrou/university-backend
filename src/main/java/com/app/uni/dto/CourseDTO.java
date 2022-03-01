package com.app.uni.dto;
import com.app.uni.model.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourseDTO {

    private Long id;
    private String code;
    private String description;
    private UserDTO userDTO;
}
