package com.dt.core.daoimpl;

import com.dt.core.common.utils.HibernateUtil;
import com.dt.core.dao.UserDao;
import com.dt.core.data.daoimpl.AbstractDao;
import com.dt.core.dto.UserDTO;
import com.dt.core.persistence.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao {

    @Override
    public UserEntity findUserByUsernameAndPassword(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("FROM UserEntity WHERE name = :name AND password = :password");
            Query query = session.createQuery(sql.toString());
            query.setParameter("name",userDTO.getName());
            query.setParameter("password",userDTO.getPassword());
            //get first row
            userEntity = (UserEntity) query.uniqueResult();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return userEntity;
    }


}
