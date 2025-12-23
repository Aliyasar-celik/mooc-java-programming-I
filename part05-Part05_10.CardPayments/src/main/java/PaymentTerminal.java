
public class PaymentTerminal {

    private double money; // amount of cash
    private int affordableMeals; // number of sold affordable meals
    private int heartyMeals; // number of sold hearty meals

    public PaymentTerminal() {
        this.money = 1000;
    }

    public double eatAffordably(double payment) {
        // an affordable meal costs 2.50 euros
        double eatAffordablyCost = 2.5;

        // increase the amount of cash by the price of an affordable mean and return the
        // change

        // if the payment parameter is not large enough, no meal is sold and the method
        // should return the whole

        if (payment < eatAffordablyCost) {

            return payment;
        } else {

            money += eatAffordablyCost;
            affordableMeals += 1;

            return (payment - eatAffordablyCost);
        }

    }

    public boolean eatAffordably(PaymentCard card) {
        // an affordable meal costs 2.50 euros
        double eatAffordablyCost = 2.5;

        // increase the amount of cash by the price of an affordable mean and return the
        // change

        // if the payment parameter is not large enough, no meal is sold and the method
        // should return the whole
        if (card.takeMoney(eatAffordablyCost)) {

            affordableMeals += 1;
            return true;
        } else {

            return false;
        }

    }

    public double eatHeartily(double payment) {

        // a hearty meal costs 4.30 euros

        double eatHeartilyCost = 4.3;

        // increase the amount of cash by the price of a hearty mean and return the
        // change
        // if the payment parameter is not large enough, no meal is sold and the method
        // should return the whole payment

        if (payment < eatHeartilyCost) {

            return payment;
        } else {

            money += eatHeartilyCost;
            heartyMeals += 1;

            return (payment - eatHeartilyCost);
        }
    }

    public boolean eatHeartily(PaymentCard card) {

        // a hearty meal costs 4.30 euros

        double eatHeartilyCost = 4.3;

        // increase the amount of cash by the price of a hearty mean and return the
        // change
        // if the payment parameter is not large enough, no meal is sold and the method
        // should return the whole payment

        if (card.takeMoney(eatHeartilyCost)) {

            heartyMeals += 1;
            return true;
        } else {

            return false;
        }
    }

    public void addMoneyToCard(PaymentCard card, double sum) {
        if (sum > 0) {
            card.addMoney(sum);
            this.money += sum;
        }
    }

    @Override
    public String toString() {
        return "money: " + money + ", number of sold affordable meals: " + affordableMeals
                + ", number of sold hearty meals: " + heartyMeals;
    }
}
