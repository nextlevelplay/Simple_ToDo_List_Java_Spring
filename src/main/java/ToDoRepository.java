import domain.ToDoEntity;

import java.util.List;

public interface ToDoRepository {

    ToDoEntity createToDo(ToDoEntity entity);
    List<ToDoEntity> showAllToDo();
    ToDoEntity updateToDo(ToDoEntity entity, String newName, String newDescription);
    void removeToDo(Integer id);

}
