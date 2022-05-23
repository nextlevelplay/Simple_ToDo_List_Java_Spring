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
        var updatedEntity = findById(entity.getId()).orElseThrow();
        updatedEntity.setName(entity.getName());
        updatedEntity.setDescription(entity.getDescription());
        var updateQuery = "UPDATE todo SET name = ?, description = ? WHERE id = ?";
        jdbcTemplate.update(updateQuery, updatedEntity.getName(), updatedEntity.getDescription(), entity.getId());
        return updatedEntity;
    }

    @Override
    public boolean remove(Integer id) {
        String deleteQuery = "DELETE FROM todo WHERE id=?";
        jdbcTemplate.update(deleteQuery, id);
        return true;
    }

    @Override
    public Optional<ToDoEntity> findById(Integer id) {
        var result = jdbcTemplate.queryForObject("SELECT * FROM todo WHERE id=?", new BeanPropertyRowMapper<>(ToDoEntity.class), new Object[]{id});
        return Optional.ofNullable(result);
    }

}
