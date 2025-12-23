public class Counter {
    private int value;

    public Counter() {
        this.value = 0;
    }

    public Counter(int value) {
        this.value = value;
    }

    public void increase() {
        this.value = this.value + 1;
    }

    public void increase(int number) {
        if (number > 0) {
            this.value = this.value + number;
        }
    }

    public void decrease() {
        this.value = this.value - 1;
    }

    public void decrease(int number) {
        if (number > 0) {
            this.value = this.value - number;
        }
    }

    public int value() {
        return value;
    }
}