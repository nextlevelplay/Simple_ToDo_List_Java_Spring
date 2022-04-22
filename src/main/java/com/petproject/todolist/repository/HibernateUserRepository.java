package com.petproject.todolist.repository;

import com.petproject.todolist.domain.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HibernateUserRepository implements ToDoRepository<UserEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public UserEntity create(UserEntity entity) {
        sessionFactory.openSession().save(entity);
        return entity;
    }

    @Override
    public List<UserEntity> showAll() {
        return sessionFactory.openSession().createQuery("SELECT u FROM users u").getResultList();
    }

    @Override
    public UserEntity update(UserEntity entity) {
        sessionFactory.openSession().update(entity);
        return entity;
    }

    @Override
    public boolean remove(Integer id) {
        var session = sessionFactory.openSession();
        var entity = session.load(UserEntity.class, id);
        try {
            session.delete(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public UserEntity findById(Integer id) {
        return sessionFactory.openSession().get(UserEntity.class, id);
    }
}
