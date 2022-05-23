package com.petproject.todolist.core;

import com.petproject.todolist.domain.ToDoEntity;
import com.petproject.todolist.repository.ArrayListToDoListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FindByIdTaskServiceTest {

    @Mock
    ArrayListToDoListRepository repository;

    @InjectMocks
    FindByIdTaskService findByIdTaskService;

    @Test
    void happyPathFindByIdTestCase() {

        // Prepare data
        var entity = new ToDoEntity();
        entity.setId(1);
        entity.setName("Test");
        entity.setDescription("Test description");

        Mockito.when(repository.findById(1)).thenReturn(Optional.of(entity));

        //Received data
        var receivedData = findByIdTaskService.findById(1);

        // ActualResult Data
        var actualResult = new ToDoEntity();
        actualResult.setId(receivedData.getTask().getId());
        actualResult.setName(receivedData.getTask().getName());
        actualResult.setDescription(receivedData.getTask().getDescription());
        actualResult.setUserId(receivedData.getTask().getUserId());


        // ExpectedResult Data
        var expectedResult = entity;

        // Checking
        assertEquals(expectedResult, actualResult);


    }
}