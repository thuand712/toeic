package com.dt.core.dao;

import com.dt.core.data.dao.GenericDao;
import com.dt.core.dto.UserDTO;
import com.dt.core.persistence.entity.RoleEntity;
import com.dt.core.persistence.entity.UserEntity;

public interface UserDao extends GenericDao<Integer, UserEntity> {
    UserEntity findUserByUsernameAndPassword(UserDTO userDTO);

}
