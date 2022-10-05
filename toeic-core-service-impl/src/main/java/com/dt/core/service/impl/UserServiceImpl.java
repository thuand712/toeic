package com.dt.core.service.impl;

import com.dt.core.dao.UserDao;
import com.dt.core.daoimpl.UserDaoImpl;
import com.dt.core.dto.UserDTO;
import com.dt.core.persistence.entity.UserEntity;
import com.dt.core.service.UserService;
import com.dt.core.utils.UserBeanUtil;

public class UserServiceImpl implements UserService {


    @Override
    public UserDTO isUserExist(UserDTO userDTO) {
        UserDao userDao = new UserDaoImpl();
        UserEntity userEntity = userDao.findUserByUsernameAndPassword(userDTO);
        return UserBeanUtil.entityToDto(userEntity);
    }

    @Override
    public UserDTO findRoleByUser(UserDTO userDTO) {
        UserDao userDao = new UserDaoImpl();
        UserEntity userEntity = userDao.findUserByUsernameAndPassword(userDTO);
        return UserBeanUtil.entityToDto(userEntity);
    }
}
