import domain.ToDoEntity;

import java.util.List;

public interface ToDoRepository {

    ToDoEntity createToDo(ToDoEntity entity);
    List<ToDoEntity> showAllToDo();
    void updateToDo();
    void removeToDo(Integer id);

}
