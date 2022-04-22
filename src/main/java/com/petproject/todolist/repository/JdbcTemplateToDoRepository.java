package com.petproject.todolist.repository;

import com.petproject.todolist.domain.ToDoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Statement;
import java.util.List;
import java.util.Optional;


public class JdbcTemplateToDoRepository implements ToDoRepository<ToDoEntity> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ToDoEntity create(ToDoEntity entity) {
        var insertQuery = "INSERT INTO todo(name, description) VALUES (?, ?)";
        var keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getDescription());
            return ps;
        }, keyHolder);
        entity.setId(keyHolder.getKey().intValue());
        return entity;
    }

    @Override
    public List<ToDoEntity> showAll() {
        var showAllQuery = "SELECT * FROM todo";
        return jdbcTemplate.query(showAllQuery, new BeanPropertyRowMapper<>(ToDoEntity.class));

    }

    @Override
    public ToDoEntity update(ToDoEntity entity) {
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        String deleteQuery = "DELETE FROM todo WHERE id=?";
        jdbcTemplate.update(deleteQuery, id);
        return true;
    }

    @Override
    public Optional<ToDoEntity> findById(Integer id) {
        return null;
    }
}
