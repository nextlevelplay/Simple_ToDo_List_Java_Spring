package com.petproject.todolist.repository;

import com.petproject.todolist.domain.ToDoEntity;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class HibernateToDoRepository implements ToDoRepository{

    @Autowired
    private final SessionFactory sessionFactory;

    @Override
    public ToDoEntity createToDo(ToDoEntity entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public List<ToDoEntity> showAllToDo() {
//        return sessionFactory.getCurrentSession().createCriteria(ToDoEntity.class).list();
        return sessionFactory.getCurrentSession().createQuery("SELECT t FROM todo t").getResultList();
    }

    @Override
    public ToDoEntity updateToDo(ToDoEntity entity) {
        sessionFactory.getCurrentSession().update(entity);
        return entity;
    }

    @Override
    public boolean removeToDo(Integer id) {
        var session = sessionFactory.getCurrentSession();
        var entity = session.load(ToDoEntity.class, id);
        try {
            session.delete(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ToDoEntity findById(Integer id) {
        return sessionFactory.getCurrentSession().get(ToDoEntity.class, id);

    }
}
