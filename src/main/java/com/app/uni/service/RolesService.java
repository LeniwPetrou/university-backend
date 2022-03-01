package com.app.uni.service;

import com.app.uni.dto.RolesDTO;
import com.app.uni.dto.UserDTO;
import com.app.uni.model.Roles;

import java.util.List;

public interface RolesService {
    public RolesDTO addRoles(RolesDTO rolesDTO);
    public List<RolesDTO> findAllRoles();
    public Roles toEntity (RolesDTO rolesDTO, String status);
    public RolesDTO toDTO (Roles roles);
    public List<RolesDTO> deleteUserById (List <RolesDTO> rolesDTO);
}
