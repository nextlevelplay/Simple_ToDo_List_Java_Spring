package com.petproject.todolist.repository;

import java.sql.Statement;
import com.petproject.todolist.domain.ToDoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class RealDataBase implements ToDoRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public RealDataBase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ToDoEntity createToDo(ToDoEntity entity) {
        var query = "INSERT INTO todo(name, description) VALUES (?, ?)";
        var keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getDescription());
            return ps;
        }, keyHolder);
        entity.setId(keyHolder.getKey().intValue());
        return entity;
    }

    @Override
    public List<ToDoEntity> showAllToDo() {
        return jdbcTemplate.query("SELECT * FROM todo", new BeanPropertyRowMapper<>(ToDoEntity.class));
    }

    @Override
    public ToDoEntity updateToDo(ToDoEntity entity) {
        var updatedEntity = findById(entity.getId());
        updatedEntity.setName(entity.getName());
        updatedEntity.setDescription(entity.getDescription());
        var updateQuery = "UPDATE todo SET name = ?, description = ? WHERE id = ?";
        jdbcTemplate.update(updateQuery, updatedEntity.getName(), updatedEntity.getDescription(),entity.getId());
        return updatedEntity;
    }

    @Override
    public boolean removeToDo(Integer id) {
        String deleteQuery = "DELETE FROM todo WHERE id=?";
        jdbcTemplate.update(deleteQuery, id);
        return true;
    }

    @Override
    public ToDoEntity findById(Integer id) {
        var result = jdbcTemplate.queryForObject("SELECT * FROM todo WHERE id=?", new BeanPropertyRowMapper<>(ToDoEntity.class), new Object[]{id});
        return result;
    }
}