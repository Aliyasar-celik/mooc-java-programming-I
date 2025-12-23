import java.util.Scanner;

public class UserInterface {

    private JokeManager jokeManager;
    private Scanner scanner;

    public UserInterface(JokeManager jokeManager, Scanner scanner) {

        this.jokeManager = jokeManager;
        this.scanner = scanner;

    }

    public void start() {

        while (true) {

            String command;

            System.out.println("Commands:");
            System.out.println("1 - add a joke");
            System.out.println("2 - draw a joke");
            System.out.println("3 - list jokes");
            System.out.println("X - stop");

            command = this.scanner.nextLine();

            if (command.equalsIgnoreCase("1")) {

                System.out.print("Write the joke to be added:");
                String jokeToAdd = scanner.nextLine();
                this.jokeManager.addJoke(jokeToAdd);

            } else if (command.equalsIgnoreCase("2")) {

                System.out.println(this.jokeManager.drawJoke());

            } else if (command.equalsIgnoreCase("3")) {

                this.jokeManager.printJokes();
            
            } else if (command.equalsIgnoreCase("x")) {

                return;
            }

        }

    }

}
