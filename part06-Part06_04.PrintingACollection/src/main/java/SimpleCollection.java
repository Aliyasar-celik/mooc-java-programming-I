
import java.util.ArrayList;

public class SimpleCollection {

    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }

    @Override
    public String toString() {

        String printString = "";

        String collectionString = "";

        if (elements.isEmpty()) {

            return "The collection " + this.name + " is empty.";
        }

        else if (elements.size() == 1) {

            printString = "The collection " + this.name + " has " + elements.size() + " element:";

            collectionString = elements.get(0);

        } else {

            printString = "The collection " + this.name + " has " + elements.size() + " elements:";

            for (String element : this.elements) {

                collectionString += element + "\n";
            }

        }

        return printString + "\n" + collectionString;

    }

}
