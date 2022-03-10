import com.petproject.todolist.domain.ToDoEntity;
import org.junit.jupiter.api.Test;
import com.petproject.todolist.repository.ToDoListRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListRepositoryTest {

    ToDoListRepository repository = new ToDoListRepository();


    // Test createToDo method
    @Test
    void createToDoTest(){

        // Prepare data
        ToDoEntity entity = new ToDoEntity();
        entity.setName("Dota2");
        entity.setDescription("get 6000 mmr");
        // Checking
        var expectedResult = entity;
        var actualResult = repository.createToDo(entity);
        assertEquals(expectedResult,actualResult);
    }

    // Test showAllToDo method
    @Test
    void showAllToDoTest(){

        // Prepare data
        ToDoEntity entity = new ToDoEntity();
        entity.setName("Dota2");
        entity.setDescription("get 6000 mmr");
        repository.createToDo(entity);
        // Checking
        var expectedResult = List.of(entity);
        var actualResult = repository.showAllToDo();
        assertEquals(expectedResult,actualResult);
    }

    // Test updateToDo method
    @Test
    void updateToDo(){

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
        var actualResult = repository.updateToDo(entity,updateName,updateDescription);
        assertEquals(expectedResult,actualResult);
    }

    // Test removeToDo method
    @Test
    void removeToDo(){

        // Prepare data
        ToDoEntity entity = new ToDoEntity();
        entity.setName("Dota2");
        entity.setDescription("get 6000 mmr");
        repository.createToDo(entity);
        // Checking
        var expectedResult = true;
        var actualResult = repository.removeToDo(1);
        assertEquals(expectedResult,actualResult);
    }


}