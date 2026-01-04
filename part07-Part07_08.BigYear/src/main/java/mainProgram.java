
import java.util.Scanner;

public class mainProgram {

    public static void main(String[] args) {
        // NB! Do not create other scanner objects than the one below
        // if and when you create other classes, pass the scanner to them
        // as a parameter

        Scanner scan = new Scanner(System.in);
        BirdDB database = new BirdDB();

        while (true) {
            System.out.print("? ");
            if (!scan.hasNextLine()) {
                break;
            }

            String command = scan.nextLine();
            if (command.equals("Quit")) {
                break;
            }

            if (command.equals("Add")) {
                System.out.print("Name: ");
                String name = scan.nextLine();
                System.out.print("Name in Latin: ");
                String latinName = scan.nextLine();
                database.addBird(name, latinName);
            } else if (command.equals("Observation")) {
                System.out.print("Bird? ");
                String name = scan.nextLine();
                if (!database.observe(name)) {
                    System.out.println("Not a bird!");
                }
            } else if (command.equals("All")) {
                for (Observation observation : database.getAll()) {
                    System.out.println(observation);
                }
            } else if (command.equals("One")) {
                System.out.print("Bird? ");
                String name = scan.nextLine();
                Observation observation = database.getObservation(name);
                if (observation == null) {
                    System.out.println("Not a bird!");
                } else {
                    System.out.println(observation);
                }
            }
        }
    }

}
