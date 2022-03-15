package com.petproject.todolist.core;

import com.petproject.todolist.domain.ToDoEntity;
import com.petproject.todolist.dto.ShowAllTaskResponse;
import com.petproject.todolist.dto.TaskDTO;
import com.petproject.todolist.repository.ToDoListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ShowAllTaskServiceTest {

    @Mock
    ToDoListRepository repository;

    @InjectMocks
    ShowAllTaskService showAllTaskService;

    @Test
    void happyPathShowAllToDoTestCase() {

        // Prepare data
        var entity = new ToDoEntity();
        entity.setId(1);
        entity.setName("Test");
        entity.setDescription("Test_description");

        // Prepare DTO
        var dto = new TaskDTO();
        dto.setId(1);
        dto.setName("Test");
        dto.setDescription("Test_description");

        // Prepare expectedResult
        List<TaskDTO> tasks = List.of(dto);
        var expectedResult = new ShowAllTaskResponse(tasks);

        Mockito.when(repository.showAllToDo()).thenReturn(List.of(entity));

        // ActualResult data
        var actualResult = showAllTaskService.showAllToDo();

        assertEquals(expectedResult,actualResult);

    }
}