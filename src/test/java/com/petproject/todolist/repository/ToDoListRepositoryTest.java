package com.petproject.todolist.repository;

import com.petproject.todolist.domain.ToDoEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListRepositoryTest {

    @Mock
    ToDoRepository repository = Mockito.mock(ToDoListRepository.class);

    // Test createToDo method
    @Test
    void createToDoTest() {

        // Prepare data:

        //Actual Data
        var entity = new ToDoEntity();
        entity.setName("Dota2");
        entity.setDescription("get 6000 mmr");

        //ExpectedResult Data
        var returnEntity = new ToDoEntity();
        returnEntity.setName("Dota2");
        returnEntity.setDescription("get 6000 mmr");
        Mockito.when(repository.createToDo(entity)).thenReturn(returnEntity);

        // Checking
        var expectedResult = entity;
        var actualResult = repository.createToDo(entity);
        assertEquals(expectedResult, actualResult);

    }

    // Test showAllToDo method
    @Test
    void showAllToDoTest() {

        // Prepare data
        ToDoEntity entity = new ToDoEntity();
        entity.setName("Dota2");
        entity.setDescription("get 6000 mmr");
        repository.createToDo(entity);
        // Checking
        var expectedResult = List.of(entity);
        var actualResult = repository.showAllToDo();
        assertEquals(expectedResult, actualResult);
    }

    // Test updateToDo method
    @Test
    void updateToDo() {

        // Prepare data
        ToDoEntity entity = new ToDoEntity();
        entity.setName("Dota2");
        entity.setDescription("get 6000 mmr");
        repository.createToDo(entity);
        String updateName = "WarCraft";
        String updateDescription = "For the Horde!";
        ToDoEntity updatedEntity = new ToDoEntity();
        updatedEntity.setId(1);
        updatedEntity.setName("WarCraft");
        updatedEntity.setDescription("For the Horde!");
        // Checking
        var expectedResult = updatedEntity;
        var actualResult = repository.updateToDo(entity);
        assertEquals(expectedResult, actualResult);
    }

    // Test removeToDo method
    @Test
    void removeToDo() {

        // Prepare data
        ToDoEntity entity = new ToDoEntity();
        entity.setName("Dota2");
        entity.setDescription("get 6000 mmr");
        repository.createToDo(entity);
        // Checking
        var expectedResult = true;
        var actualResult = repository.removeToDo(1);
        assertEquals(expectedResult, actualResult);
    }

}