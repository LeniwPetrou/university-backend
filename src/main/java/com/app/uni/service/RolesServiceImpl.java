package com.app.uni.service;

import com.app.uni.dto.RolesDTO;
import com.app.uni.model.Roles;
import com.app.uni.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesServiceImpl implements RolesService{

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public RolesDTO addRoles(RolesDTO rolesDTO){
        Roles roles = this.toEntity(rolesDTO, "add");
        Roles newRoles = rolesRepository.save(roles);
        RolesDTO newRolesDTO = this.toDTO(newRoles);
        return newRolesDTO;
    }

    @Override
    public List<RolesDTO> findAllRoles(){
        List<Roles> roles = rolesRepository.findAll();
        List<RolesDTO> rolesDTO = new ArrayList<>();
        for (Roles role:roles){
            rolesDTO.add(this.toDTO(role));
        }
        return rolesDTO;
    }

    public List<RolesDTO> deleteUserById (List <RolesDTO> rolesDTO){
        List <Long> listIds = new ArrayList<>();
        for (int i =0; i< rolesDTO.size();i++){
            listIds.add(rolesDTO.get(i).getId());
        }
        rolesRepository.deleteRoleByIds(listIds);
        return rolesDTO;
    }

    @Override
    @Transactional
    public Roles toEntity (RolesDTO rolesDTO, String status){
        Roles roles = null;
        if (status == "add") {
            roles = new Roles();
        }
        else {
            roles = rolesRepository.findById(rolesDTO.getId()).get();
        }
        roles.setDescription(rolesDTO.getDescription());
        return roles;
    }

    @Override
    public RolesDTO toDTO (Roles roles){
        RolesDTO rolesDTO = new RolesDTO();
        rolesDTO.setId(roles.getId());
        rolesDTO.setDescription(roles.getDescription());
        return rolesDTO;
    }
}
