package com.dt.core.utils;

import com.dt.core.dto.UserDTO;
import com.dt.core.persistence.entity.UserEntity;

public class UserBeanUtil {
    public static UserDTO entityToDto(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setName(userEntity.getName());
        userDTO.setCreatedDate(userEntity.getCreatedDate());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setFullName(userEntity.getFullName());
        userDTO.setRoleDTO(RoleBeanUtil.entityToDto(userEntity.getRole()));
        return userDTO;
    }
    public static UserEntity dtoToEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setName(userDTO.getName());
        userEntity.setCreatedDate(userDTO.getCreatedDate());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setFullName(userDTO.getFullName());
        userEntity.setRole(RoleBeanUtil.dtoToEntity(userDTO.getRoleDTO()));
        return userEntity;
    }
}
