package com.petproject.todolist.core;

import com.petproject.todolist.domain.ToDoEntity;
import com.petproject.todolist.dto.UpdateTaskRequest;
import com.petproject.todolist.dto.UpdateTaskResponse;
import com.petproject.todolist.repository.ArrayListToDoListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateTaskServiceTest {

    @Mock
    ArrayListToDoListRepository repository;

    @InjectMocks
    UpdateTaskService updateTaskService;

    @Test
    void happyPathUpdateToDoTestCase() {

        // Entity
        var entity = new ToDoEntity();
        entity.setId(1);
        entity.setName("Test");
        entity.setDescription("Test_description");

        // Updated entity
        var updatedEntity = new ToDoEntity();
        updatedEntity.setId(1);
        updatedEntity.setName("John_Snow");
        updatedEntity.setDescription("How_protect_the_wall?");


        // Prepare Request
        var request = new UpdateTaskRequest();
        request.setId(1);
        request.setName("Test");
        request.setDescription("Test_description");

        // Prepare Response
        var response = new UpdateTaskResponse();
        response.setId(1);
        response.setName("John_Snow");
        response.setDescription("How_protect_the_wall?");

        Mockito.when(repository.update(entity)).thenReturn(updatedEntity);

        var actualResult = updateTaskService.updateToDo(request);

        var expectedResult = response;

        assertEquals(expectedResult,actualResult);


    }
}