package com.dt.core.test;

import com.dt.core.dao.UserDao;
import com.dt.core.daoimpl.UserDaoImpl;
import com.dt.core.dto.UserDTO;
import com.dt.core.persistence.entity.RoleEntity;
import com.dt.core.persistence.entity.UserEntity;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LoginTest {

    /*private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void checkIsUserExist(){
        UserDao userDao = new UserDaoImpl();
        UserDTO userDTO = new UserDTO();
        userDTO.setName("thuan");
        userDTO.setPassword("123456");
        UserEntity userEntity = userDao.isUserExist(userDTO);

        if(userEntity != null){
            log.error("Login successfully");
        }else {
            log.error("Login fail");
        }
    }

    @Test
    public void checkFindRoleByUser(){
        UserDao userDao = new UserDaoImpl();
        UserDTO userDTO = new UserDTO();
        userDTO.setName("thuan");
        userDTO.setPassword("123456");
        UserEntity userEntity = userDao.isUserExist(userDTO);
        RoleEntity roleEntity = userEntity.getRole();
        if(userEntity != null){
            log.error("Login successfully");
        }else {
            log.error("Login fail");
        }

    }*/
}
