package com.dt.core.data.daoimpl;

import com.dt.core.common.constant.CoreConstant;
import com.dt.core.common.utils.HibernateUtil;
import com.dt.core.data.dao.GenericDao;
import org.hibernate.*;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID,T> {
    private Class<T> persistenceClass;

    public AbstractDao(){
        //
        this.persistenceClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public String getPersistenceClassName(){
        return persistenceClass.getSimpleName();
    }

    @Override
    public List<T> findAll() {
        List<T> list = new ArrayList<T>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            //HQL
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());
            Query query = session.createQuery(sql.toString());
            list = query.list();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }

        return list;
    }

    @Override
    public T update(T entity) {
        T result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            result  = (T) session.merge(entity);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }

        return result;
    }

    @Override
    public void save(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public T findById(ID id) {
        T result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            result = (T) session.get(persistenceClass, id);
            if (result == null){
                throw new ObjectNotFoundException("NOT FOUND "+ id, null);
            }
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }

        return result;
    }

    @Override
    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        List<T> list = new ArrayList<T>();
        Object totalItem = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        String[] params = new String[property.size()];
        Object[] values = new Object[property.size()];
        int i = 0;
        for (Map.Entry item:property.entrySet()) {
            params[i] = (String) item.getKey();
            values[i] = item.getValue();
            i++;
        }
        try {
            transaction = session.beginTransaction();
            StringBuilder sql = new StringBuilder("from ");
            sql.append(getPersistenceClassName());
            sql.append(" where 1 = 1 ");
            if (property.size() > 0){
                for(int j = 0; j<property.size(); j++){
                    sql.append(" and " + params[j] + " = :"+params[j]);
                }
            }

            if(sortExpression != null && sortDirection != null){
                sql.append(" order by ").append(sortExpression);
                sql.append(" "+(sortDirection.equals(CoreConstant.SORT_ASC)?"asc":"desc"));
            }
            Query query = session.createQuery(sql.toString());
            if (property.size() > 0){
                for(int j = 0; j<property.size(); j++){
                    query.setParameter(params[j],values[j]);
                }
            }

            if(offset != null && offset >= 0){
                query.setFirstResult(offset);
            }

            if(limit != null && limit >= 0){
                query.setMaxResults(limit);
            }

            list = query.list();

            StringBuilder sqlGetSize = new StringBuilder("select count(*) from ");
            sqlGetSize.append(getPersistenceClassName());
            sqlGetSize.append(" where 1 = 1 ");

            if (property.size() > 0){
                for(int j = 0; j<property.size(); j++){
                    sqlGetSize.append(" and " + params[j] + " = :"+params[j]);
                }
            }
            Query queryGetSize = session.createQuery(sqlGetSize.toString());
            if (property.size() > 0){
                for(int j = 0; j<property.size(); j++){
                    queryGetSize.setParameter(params[j],values[j]);
                }
            }
            totalItem = queryGetSize.list().get(0);

            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }

        return new  Object[]{totalItem,list};
    }

    @Override
    public Integer delete(List<ID> ids) {
        Integer count = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            for(ID item: ids){
                T t = (T) session.get(persistenceClass, item);
                session.delete(t);
                count++;
            }

            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }

        return count;
    }
}
