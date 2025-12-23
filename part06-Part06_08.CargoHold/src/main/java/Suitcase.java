import java.util.ArrayList;

public class Suitcase {

    private ArrayList<Item> items;

    private int maxWeight;
    private int totalWeight;

    public Suitcase(int maxWeight) {

        this.maxWeight = maxWeight;
        this.totalWeight = 0;
        this.items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getTotalWeight() {

        this.totalWeight = 0;

        for (Item suitcaseItem : items) {

            this.totalWeight += suitcaseItem.getWeight();

        }

        return totalWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void addItem(Item item) {

        this.totalWeight = 0;

        for (Item suitcaseItem : items) {

            this.totalWeight += suitcaseItem.getWeight();

        }

        if ((totalWeight + item.getWeight()) <= this.maxWeight) {

            items.add(item);

            this.totalWeight = 0;

            for (Item suitcaseItem : items) {

                this.totalWeight += suitcaseItem.getWeight();

            }

        }

    }

    public String toString() {

        if (items.size() == 0) {

            return "no items (" + this.getTotalWeight() + " kg)";

        } else if (items.size() == 1) {

            return items.size() + " item (" + this.getTotalWeight() + " kg)";

        } else {
            return items.size() + " items (" + this.getTotalWeight() + " kg)";

        }

    }

    public void printItems() {

        for (Item item : items) {
            System.out.println(item);
        }
    }

    public int totalWeight() {

        return this.totalWeight;
    }

    public Item heaviestItem() {

        if (items.isEmpty()) {

            return null;
        }

        Item heaviesItem = items.get(0);

        for (Item item : this.items) {

            if (item.getWeight() > heaviesItem.getWeight()) {

                heaviesItem = item;
            }
        }
        return heaviesItem;

    }
}
