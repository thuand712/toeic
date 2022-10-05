package com.dt.core.utils;

import com.dt.core.dto.RoleDTO;
import com.dt.core.dto.UserDTO;
import com.dt.core.persistence.entity.RoleEntity;
import com.dt.core.persistence.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class RoleBeanUtil {
    public static RoleDTO entityToDto(RoleEntity roleEntity){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(roleEntity.getRoleId());
        roleDTO.setName(roleEntity.getName());
        return roleDTO;
    }
    public static RoleEntity dtoToEntity(RoleDTO roleDTO){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(roleDTO.getRoleId());
        roleEntity.setName(roleDTO.getName());
        return roleEntity;
    }
}
