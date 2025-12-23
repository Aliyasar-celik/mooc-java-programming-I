import java.util.ArrayList;

public class Hold {

    private ArrayList<Suitcase> suitcasesOnHold;
    private int maxWeight;
    private int totalWeight;

    public Hold(int maxWeight) {

        this.maxWeight = maxWeight;
        this.suitcasesOnHold = new ArrayList<Suitcase>();
    }

    public void addSuitcase(Suitcase suitcase) {

        this.totalWeight = 0;

        for (Suitcase suitcase1 : this.suitcasesOnHold) {

            this.totalWeight += suitcase1.getTotalWeight();

        }

        if ((this.totalWeight + suitcase.getTotalWeight()) <= this.maxWeight) {

            this.suitcasesOnHold.add(suitcase);

            this.totalWeight = 0;

            for (Suitcase suitcase1 : this.suitcasesOnHold) {

                this.totalWeight += suitcase1.getTotalWeight();

            }

        }
    }

    public void printItems() {

        for (Suitcase suitcase1 : suitcasesOnHold) {
            for (Item itemInSuitcase : suitcase1.getItems()) {

                System.out.println(itemInSuitcase);
            }
        }
    }

    @Override
    public String toString() {

        return suitcasesOnHold.size() + " suitcases (" + this.totalWeight + "kg)";
    }
}
