package com.dt.core.test;

import com.dt.core.dao.RoleDao;
import com.dt.core.daoimpl.RoleDaoImpl;
import com.dt.core.persistence.entity.RoleEntity;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RoleTest {
    /*
    @Test
    public void checkFindAll(){
        RoleDao roleDao = new RoleDaoImpl();
        List<RoleEntity> list = roleDao.findAll();
        for (RoleEntity roleEntity: list) {
            System.out.println(roleEntity.getRoleId() + "-"+roleEntity.getName());
        }
    }

    @Test
    public void checkUpdateRole(){
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(3);
        roleEntity.setName("MANAGER");
        roleDao.update(roleEntity);
    }

    @Test
    public void checkSaveRole(){
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(1);
        roleEntity.setName("ADMIN");
        roleDao.save(roleEntity);
    }

    @Test
    public void findById(){
        RoleDao roleDao = new RoleDaoImpl();
        roleDao.findById(2);
    }

    @Test
    public void checkfindByProperty(){
        RoleDao roleDao = new RoleDaoImpl();
        String property = "roleid";
        Object value = "1";
        String sortExpression = "name";
        String sortDirection = "1";
        Object[] objects = roleDao.findByProperty(property,value,sortExpression,sortDirection);

    }

    @Test
    public void checkDelete(){
        RoleDao roleDao = new RoleDaoImpl();
        List<Integer>list = new ArrayList<>();
        list.add(3);
        int count = roleDao.delete(list);
        System.out.println(count);
    }

     */
}
