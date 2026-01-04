public class Observation {
    private final Bird bird;
    private int count;

    public Observation(Bird bird) {
        this.bird = bird;
        this.count = 0;
    }

    public Bird getBird() {
        return bird;
    }

    public int getCount() {
        return count;
    }

    public void observe() {
        this.count++;
    }

    public boolean matchesName(String name) {
        return bird.getName().equals(name);
    }

    @Override
    public String toString() {
        return bird.getName() + " (" + bird.getLatinName() + "): " + count + " observations";
    }

}
