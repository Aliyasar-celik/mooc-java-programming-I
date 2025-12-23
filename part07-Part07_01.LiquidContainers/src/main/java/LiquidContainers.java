
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstContainer = 0;
        int secondContainer = 0;
        while (true) {

            System.out.println();
            System.out.println("First: " + firstContainer + "/" + "100");
            System.out.println("Second: " + secondContainer + "/" + "100");

            String input = scan.nextLine();
            String[] parts = input.split(" ");

            String command = parts[0];
            int amount = command.equalsIgnoreCase("quit") ? 0 : Integer.valueOf(parts[1]);

            if (command.equalsIgnoreCase("quit")) {
                break;
            } else if (command.equalsIgnoreCase("add")) {

                if (amount < 0) {
                    continue;
                }
                if (amount <= 100 - firstContainer) {

                    firstContainer += amount;
                } else if (amount + firstContainer > 100) {
                    firstContainer = 100;
                }

            } else if (command.equalsIgnoreCase("move")) {

                if (amount < 0) {
                    continue;
                }

                if (amount < firstContainer) {

                    firstContainer -= amount;
                    secondContainer += amount;
                } else {
                    secondContainer += firstContainer;
                    firstContainer = 0;
                }

                if (secondContainer > 100) {

                    secondContainer = 100;
                }

            } else if (command.equalsIgnoreCase("remove")) {

                if (amount < 0) {
                    continue;
                }

                if (amount < secondContainer) {

                    secondContainer -= amount;
                } else {
                    secondContainer = 0;
                }

            }
        }
    }

}
