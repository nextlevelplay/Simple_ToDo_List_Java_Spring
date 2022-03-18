package com.petproject.todolist.core;

import com.petproject.todolist.domain.ToDoEntity;
import com.petproject.todolist.repository.ToDoListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FindByIdTaskServiceTest {

    @Mock
    ToDoListRepository repository;

    @InjectMocks
    FindByIdTaskService findByIdTaskService;

    @Test
    void happyPathFindByIdTestCase() {

        // Prepare data
        var entity = new ToDoEntity();
        entity.setId(1);
        entity.setName("Test");
        entity.setDescription("Test description");

        Mockito.when(repository.findById(1)).thenReturn(entity);

        // ActualResult Data
        var actualResult = findByIdTaskService.findById(1);

        // ExpectedResult Data
        var expectedResult = entity;

        // Checking
        assertEquals(expectedResult, actualResult);


    }
}