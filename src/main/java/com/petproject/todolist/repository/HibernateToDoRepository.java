package com.petproject.todolist.repository;

import com.petproject.todolist.domain.ToDoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HibernateToDoRepository implements ToDoRepository<ToDoEntity>{



    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ToDoEntity create(ToDoEntity entity) {
        sessionFactory.openSession().save(entity);
        return entity;
    }

    @Override
    public List<ToDoEntity> showAll() {
//        return sessionFactory.getCurrentSession().createCriteria(ToDoEntity.class).list();
        return sessionFactory.openSession().createQuery("SELECT t FROM todo t").getResultList();
    }

    @Override
    public ToDoEntity update(ToDoEntity entity) {
        var session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        return entity;
    }

    @Override
    public boolean remove(Integer id) {
        var session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        var entity = session.load(ToDoEntity.class, id);
        try {
            session.delete(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ToDoEntity findById(Integer id) {
        return sessionFactory.openSession().get(ToDoEntity.class, id);

    }
}
