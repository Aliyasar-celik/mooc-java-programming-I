public class Item {
    String id;
    String name;

    Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(Object compared) {
        // if the variables are located in the same position, they are equal
        if (this == compared) {
            return true;
        }

        // if the compared object is not of type Item, the objects are not equal
        if (!(compared instanceof Item)) {
            return false;
        }

        // convert the object into a Item object
        Item comparedItem = (Item) compared;

        // if the values of the object variables are equal, the objects are equal
        if ((this.id.equals(comparedItem.id))) {
            return true;
        }

        // otherwise the objects are not equal
        return false;

    }

}