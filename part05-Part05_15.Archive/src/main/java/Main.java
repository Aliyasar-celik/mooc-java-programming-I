
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> items = new ArrayList<>();

        // First identifier prompt before entering the loop
        System.out.println("Identifier? (empty will stop)");
        String id = scanner.nextLine();

        // Loop continues as long as identifier is non-empty
        while (id != null && !id.trim().isEmpty()) {
            System.out.println("Name? (empty will stop)");
            String name = scanner.nextLine();

            // If name is empty, end input by making id empty for the next check (no break)
            if (name == null || name.trim().isEmpty()) {
                id = ""; // sentinel to stop the while
            } else {

                Item item = new Item(id, name);

                if (items.size() == 0) {

                    items.add(item);
                }

                boolean isItemOnTheList = false;
                for (Item bookItem : items) {

                    isItemOnTheList = item.equals(bookItem);

                }

                if (!isItemOnTheList) items.add(item);

                // Ask for the next identifier
                System.out.println("Identifier? (empty will stop)");
                id = scanner.nextLine();
            }
        }

        System.out.println();
        System.out.println("==Items==");

        for (Item it : items) {
            System.out.println(it.id + ": " + it.name);
        }
    }
}