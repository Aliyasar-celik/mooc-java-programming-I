
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Container firstContainer = new Container();
        Container secondContainer = new Container();
        while (true) {

            System.out.println();
            System.out.println("First: " + firstContainer);
            System.out.println("Second: " + secondContainer);

            String input = scan.nextLine();
            String[] parts = input.split(" ");

            String command = parts[0];
            int amount = command.equalsIgnoreCase("quit") ? 0 : Integer.valueOf(parts[1]);

            if (command.equalsIgnoreCase("quit")) {
                break;
            } else if (command.equalsIgnoreCase("add")) {

                firstContainer.add(amount);
            } else if (command.equalsIgnoreCase("move")) {

                if (amount < firstContainer.contains()) {

                    firstContainer.remove(amount);
                    secondContainer.add(amount);
                } else {
                    secondContainer.add(firstContainer.contains());
                    firstContainer.remove(amount);
                }

            } else if (command.equalsIgnoreCase("remove")) {

                secondContainer.remove(amount);

            }
        }
    }

}
