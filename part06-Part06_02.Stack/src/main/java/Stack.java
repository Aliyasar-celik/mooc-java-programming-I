import java.util.ArrayList;

public class Stack {

    ArrayList<String> listOfStrings = new ArrayList<String>();

    public boolean isEmpty() {

        if (listOfStrings.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void add(String value) {
        listOfStrings.add(value);
    }

    public ArrayList<String> values() {

        return listOfStrings;
    }

    public String take() {

        String stringToTake = this.listOfStrings.get(listOfStrings.size() - 1);
        this.listOfStrings.remove(listOfStrings.size() - 1);
    
        return stringToTake;
    }
}
