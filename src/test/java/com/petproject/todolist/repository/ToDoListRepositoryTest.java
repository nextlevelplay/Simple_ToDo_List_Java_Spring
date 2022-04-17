package com.petproject.todolist.repository;

import com.petproject.todolist.domain.ToDoEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListRepositoryTest {

    // INTEGRATION TESTS

    ToDoRepository<ToDoEntity> repository = new ArrayListToDoListRepository();

    // Test createToDo method
    @Test
    void createToDoTest() {

        // Prepare data:

        //ExpectedResult Data
        var entity = new ToDoEntity();
        entity.setName("Dota2");
        entity.setDescription("get 6000 mmr");
        var expectedResult = entity;

        //Actual Data
        var actualResult = repository.create(entity);
        assertEquals(expectedResult, actualResult);

    }

    // Test showAllToDo method
    @Test
    void showAllToDoTest() {

        // Prepare data
        ToDoEntity entity = new ToDoEntity();
        entity.setName("Dota2");
        entity.setDescription("get 6000 mmr");
        repository.create(entity);
        // Checking
        var expectedResult = List.of(entity);
        var actualResult = repository.showAll();
        assertEquals(expectedResult, actualResult);
    }

    // Test updateToDo method
    @Test
    void updateToDo() {

        // Prepare data
        // Create and save entity
        var entity = new ToDoEntity();
        entity.setName("Dota2");
        entity.setDescription("get 6000 mmr");
        repository.create(entity);

        // Create updated entity
        var updatedEntity = repository.findById(entity.getId());
        updatedEntity.setId(entity.getId());
        updatedEntity.setName("WarCraft");
        updatedEntity.setDescription("For the Horde!");

        // Update original entity
        entity.setName(updatedEntity.getName());
        entity.setDescription(updatedEntity.getDescription());

        // Checking
        var expectedResult = updatedEntity;
        var actualResult = repository.update(entity);
        assertEquals(expectedResult, actualResult);
    }

    // Test removeToDo method
    @Test
    void removeToDo() {

        // Prepare data
        ToDoEntity entity = new ToDoEntity();
        entity.setName("Dota2");
        entity.setDescription("get 6000 mmr");
        repository.create(entity);
        // Checking
        var expectedResult = true;
        var actualResult = repository.remove(1);
        assertEquals(expectedResult, actualResult);
    }

}