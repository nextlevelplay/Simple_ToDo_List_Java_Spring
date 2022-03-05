import domain.ToDoEntity;

public class Application {

    public static void main(String[] args) {

        ToDoListRepository repo = new ToDoListRepository();


        System.out.println("**************************");
        System.out.println("Try to create");
        var todo = new ToDoEntity();
        todo.setName("Dota2");
        todo.setDescription("get 6000 mmr");

        repo.createToDo(todo);

        var showAll = repo.showAllToDo();
        System.out.println("showAll = " + showAll);

        System.out.println("**************************");
        System.out.println("Try to update");

        String name = "BlaBla";
        String description = "TESTESTEST";

        repo.updateToDo(todo,name,description);


        var showAfter = repo.showAllToDo();
        System.out.println("showAfter = " + showAfter);

        System.out.println("**************************");
        System.out.println("Try to remove");

        repo.removeToDo(1);

        var showAfterRemove = repo.showAllToDo();
        System.out.println("showAfterRemove = " + showAfterRemove);






    }
}
