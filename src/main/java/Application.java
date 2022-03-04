import domain.ToDoEntity;

public class Application {

    public static void main(String[] args) {

        ToDoListRepository repo = new ToDoListRepository();

        var todo = new ToDoEntity();
        todo.setName("Dota2");
        todo.setDescription("play all night!");

        repo.createToDo(todo);


        var showAll = repo.showAllToDo();
        System.out.println("showAll = " + showAll);

        System.out.println("**************************");

        repo.removeToDo(1);

        var showAfter = repo.showAllToDo();
        System.out.println("showAfter = " + showAfter);


    }
}
