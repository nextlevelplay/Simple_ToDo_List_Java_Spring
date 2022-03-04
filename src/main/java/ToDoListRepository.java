import domain.ToDoEntity;

import java.util.ArrayList;
import java.util.List;

public class ToDoListRepository implements ToDoRepository{

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
    public void removeToDo(Integer id) {
        repository.removeIf(entity -> entity.getId().equals(id));
    }
}
