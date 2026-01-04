import java.util.ArrayList;
import java.util.List;

public class BirdDB {
    private final List<Observation> entries;

    public BirdDB() {
        this.entries = new ArrayList<>();
    }

    public void addBird(String name, String latinName) {
        this.entries.add(new Observation(new Bird(name, latinName)));
    }

    public boolean observe(String name) {
        Observation observation = getObservation(name);
        if (observation == null) {
            return false;
        }
        observation.observe();
        return true;
    }

    public Observation getObservation(String name) {
        for (Observation observation : entries) {
            if (observation.matchesName(name)) {
                return observation;
            }
        }
        return null;
    }

    public List<Observation> getAll() {
        return new ArrayList<>(entries);
    }

}
