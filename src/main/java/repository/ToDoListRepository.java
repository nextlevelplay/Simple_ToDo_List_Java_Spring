package repository;

import domain.ToDoEntity;

import java.util.ArrayList;
import java.util.List;

public class ToDoListRepository implements ToDoRepository {

    private final List<ToDoEntity> repository = new ArrayList<>();
    private Integer idSequence = 1;


    // Create ToDo
    @Override
    public ToDoEntity createToDo(ToDoEntity entity) {
        entity.setId(idSequence);
        idSequence++;
        repository.add(entity);
        return entity;
    }

    // Show all ToDo's
    @Override
    public List<ToDoEntity> showAllToDo() {
        return repository;
    }

    @Override
    public ToDoEntity findById(Integer id) {
        for (ToDoEntity value : repository) {
            if (value != null && id.equals(value.getId())) {
                return value;
            }
        }
        return null;
    }


    // Update ToDo
    @Override
    public ToDoEntity updateToDo(ToDoEntity entity, String newName, String newDescription) {
        for (ToDoEntity value : repository) {
            if (value != null && entity.getId().equals(value.getId())) {
                entity.setName(newName);
                entity.setDescription(newDescription);
            }
        }
        return entity;
    }

    // Remove ToDo
    @Override
    public boolean removeToDo(Integer id) {
        return repository.removeIf(entity -> entity.getId().equals(id));
    }

}
