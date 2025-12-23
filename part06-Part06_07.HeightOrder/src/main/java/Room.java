import java.util.ArrayList;

public class Room {

    ArrayList<Person> listOfPersons;

    public Room() {

        this.listOfPersons = new ArrayList<>();
    }

    public void add(Person person) {

        this.listOfPersons.add(person);
    }

    public boolean isEmpty() {

        return this.listOfPersons.isEmpty();

    }

    public ArrayList<Person> getPersons() {
        return this.listOfPersons;
    }

    public Person shortest() {

        if (listOfPersons.isEmpty()) {

            return null;
        }

        Person shortestPerson = listOfPersons.get(0);

        for (Person person : this.listOfPersons) {

            if (person.getHeight() < shortestPerson.getHeight()) {

                shortestPerson = person;
            }
        }
        return shortestPerson;

    }

    public Person take() {

        if (listOfPersons.isEmpty()) {

            return null;
        }

        Person shortesPerson = this.shortest();
        
        listOfPersons.remove(this.shortest());

        return shortesPerson;

    }

}
