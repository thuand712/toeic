package com.dt.core.service;

import com.dt.core.dto.UserDTO;
import com.dt.core.persistence.entity.UserEntity;

public interface UserService {
    UserDTO isUserExist(UserDTO userDTO);
    UserDTO findRoleByUser(UserDTO userDTO);
}
