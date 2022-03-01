package com.app.uni.controller;

import com.app.uni.dto.RolesDTO;
import com.app.uni.dto.UserDTO;
import com.app.uni.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RolesService rolesService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/findAllRoles")
    public List<RolesDTO> findAllRoles() {
        return rolesService.findAllRoles();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addRole")
    public RolesDTO addRole(@RequestBody RolesDTO roleDTO) {
        return rolesService.addRoles(roleDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/delete")
    public List<RolesDTO> deleteRolesNyIds (@RequestBody List <RolesDTO> rolesDTOs){
        return rolesService.deleteUserById(rolesDTOs);
    }
}
