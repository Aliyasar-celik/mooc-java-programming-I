import java.util.Scanner;

public class UserInterface {

    private TodoList todoList;
    private Scanner scanner;

    public UserInterface(TodoList todoList, Scanner scanner) {

        this.todoList = todoList;
        this.scanner = scanner;

    }

    public void start() {

        while (true) {

            System.out.print("Command: ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("stop")) {

                return;
            } else if (command.equalsIgnoreCase("add")) {

                System.out.print("To add: ");
                String toAdd = this.scanner.nextLine();
                this.todoList.add(toAdd);

            } else if (command.equalsIgnoreCase("list")) {

                todoList.print();

            } else if (command.equalsIgnoreCase("remove")) {
                System.out.print("Which one is removed? ");
                int toRemove = Integer.valueOf(scanner.nextLine());

                todoList.remove(toRemove);
            }else{
                System.out.println( "Unknown command please try agai:");
            }

        }

    }

}
