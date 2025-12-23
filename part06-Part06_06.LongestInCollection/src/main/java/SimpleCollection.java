
import java.util.ArrayList;

public class SimpleCollection {

    private String name;
    private ArrayList<String> elements;
    public String longest;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<String>();
        this.longest = "";

    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }

    public String longest() {

        for (String element : this.elements) {

            if (element.length() > this.longest.length()) {

                this.longest = element;
            }
        }
        if (this.longest.isEmpty()) {
            
            return null;
        
        } else {

            return this.longest;
        }
    }

}
