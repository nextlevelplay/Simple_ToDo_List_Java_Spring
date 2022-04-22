package com.petproject.todolist.repository;

import com.petproject.todolist.domain.ToDoEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        sessionFactory.openSession().update(entity);
        return entity;
    }

    @Override
    public boolean remove(Integer id) {
        var session = sessionFactory.openSession();
        var entity = session.load(ToDoEntity.class, id);
        try {
            session.delete(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<ToDoEntity> findById(Integer id) {
        var entity = sessionFactory.openSession().get(ToDoEntity.class, id);
        return Optional.ofNullable(entity);

    }
}
