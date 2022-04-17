package com.petproject.todolist.repository;

import com.petproject.todolist.domain.UserEntity;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class HibernateUserRepository implements ToDoRepository<UserEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public UserEntity create(UserEntity entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public List<UserEntity> showAll() {
        return sessionFactory.getCurrentSession().createQuery("SELECT u FROM users u").getResultList();
    }

    @Override
    public UserEntity update(UserEntity entity) {
        sessionFactory.getCurrentSession().update(entity);
        return entity;
    }

    @Override
    public boolean remove(Integer id) {
        var session = sessionFactory.getCurrentSession();
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
        return sessionFactory.getCurrentSession().get(UserEntity.class, id);
    }
}
