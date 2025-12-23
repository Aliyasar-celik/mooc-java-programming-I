import java.util.ArrayList;

public class TodoList {

    private ArrayList<String> tasksTodo;

    public TodoList() {

        tasksTodo = new ArrayList<String>();

    }

    public void add(String task) {

        tasksTodo.add(task);

    }

    public void print() {

        if (tasksTodo.size() == 0) {
            System.out.print("");
            return;
        }

        for (int i = 0; i < tasksTodo.size(); i++) {

            System.out.println((i+1) + ": " + tasksTodo.get(i));
        }

    }

    public void remove(int number) {

        tasksTodo.remove(number - 1);
    }
}
