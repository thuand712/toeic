package com.dt.core.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntity {

    @Id
    @Column(name = "roleid")
    private Integer roleId;

    @Column(name = "name")
    private String name;

    //LAZY (chi lay len 1 role vi du ADMIN), EAGER (lay tat ca in list)
    //EAGER get all row
    //LAZE get only row
    @OneToMany(mappedBy = "roleEntity", fetch = FetchType.LAZY)
    private List<UserEntity> userEntityList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserEntity> getUserList() {
        return userEntityList;
    }

    public void setUserList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }
}
