package com.petproject.todolist.core;
import com.petproject.todolist.core.validation.CoreError;
import com.petproject.todolist.core.validation.ValidationService;
import com.petproject.todolist.domain.ToDoEntity;
import com.petproject.todolist.dto.CreateTaskRequest;
import com.petproject.todolist.dto.CreateTaskResponse;
import com.petproject.todolist.repository.ArrayListToDoListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CreateTaskServiceTest {

    @Mock
    private ArrayListToDoListRepository repository;

    @Mock
    private ValidationService validationService;

    @InjectMocks
    private CreateTaskService victim;

    // Test createToDo method
    @Test
    void happyPathCreateToDoTestCase1() {

        // Prepare data:

        // Request
        var request = new CreateTaskRequest();
        request.setName("Test");
        request.setDescription("Test_description");
        Mockito.when(validationService.validate(request)).thenReturn(List.of());
        Mockito.when(repository.createToDo(entity(null))).thenReturn(entity(1));

        // ActualResult Data
        var actualResult = victim.createToDo(request);

        // Checking touch the repo and services
        Mockito.verify(repository).createToDo(any());
        Mockito.verify(validationService).validate(any());

        // ExpectedResult Data
        var expectedResult = new CreateTaskResponse();
        expectedResult.setId(1);
        expectedResult.setErrors(null);

        // Checking
        assertEquals(expectedResult, actualResult);

    }

    @Test
    void shouldReturnErrorsCreateToDoTestCase2(){

        // Prepare data:

        // Request
        var request = new CreateTaskRequest();
        request.setName("Test");
        request.setDescription("Test_description");
        Mockito.when(validationService.validate(request)).thenReturn(List.of(new CoreError("Any error")));

        // ActualResult Data
        var actualResult = victim.createToDo(request);

        // Checking touch the repo and services
        Mockito.verifyNoInteractions(repository);
        Mockito.verify(validationService).validate(any());

        // ExpectedResult Data
        var expectedResult = new CreateTaskResponse();
        expectedResult.setId(null);
        expectedResult.setErrors(List.of(new CoreError("Any error")));

        // Checking
        assertEquals(expectedResult, actualResult);

    }


    // Entity supplier method
    private ToDoEntity entity(Integer id){
        var entity = new ToDoEntity();
        entity.setId(id);
        entity.setName("Test");
        entity.setDescription("Test_description");
        return entity;
    }

}