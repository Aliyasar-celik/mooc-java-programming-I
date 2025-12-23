import java.util.ArrayList;

public class Package {

    private ArrayList<Gift> giftsInThePackage;

    public Package() {

        giftsInThePackage = new ArrayList<>();

    }

    public void addGift(Gift gift) {

        this.giftsInThePackage.add(gift);

    }

    public int totalWeight() {

        int totalWeightOfGifts = 0;

        for (Gift gift : giftsInThePackage) {

            totalWeightOfGifts += gift.getWeight();

        }

        return totalWeightOfGifts;
    }
}
