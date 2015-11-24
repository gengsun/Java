package sun.java.spring.mvc.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by sun on 12/11/15.
 */
public abstract class AbstractDao<K extends Serializable, T>
{
    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    protected AbstractDao()
    {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    protected T getByKey(K key)
    {
        return (T) getSession().get(persistentClass, key);
    }

    protected void persist(T entity)
    {
        getSession().persist(entity);
    }

    protected void delete(T entity)
    {
        getSession().delete(entity);
    }

    protected Criteria createEntityCriteria()
    {
        return getSession().createCriteria(persistentClass);
    }
}
