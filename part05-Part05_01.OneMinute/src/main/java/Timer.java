public class Timer {
    private ClockHand seconds;
    private ClockHand hunderthOfASecond;

    public Timer() {
        this.seconds = new ClockHand(60);
        this.hunderthOfASecond = new ClockHand(100);
    }

    public void advance() {
        this.hunderthOfASecond.advance();

        if (this.hunderthOfASecond.value() == 0) {
            this.seconds.advance();
        }
    }

    public String toString(){
        return this.seconds + ":" + hunderthOfASecond;
    }
}
