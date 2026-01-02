import java.util.ArrayList;

public class Recipe {
    private String name;
    private int cookingTime = 0;
    private ArrayList<String> ingredients;

    public void setName(String name) {
        this.name = name;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    @Override
    public String toString() {
        return "Recipe [name=" + name + ", cookingTime=" + cookingTime + ", ingredients=" + ingredients + "]";
    }

    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public Recipe(String name, int cookingTime, ArrayList<String> ingredients) {

        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;

    }

    public Recipe() {
        ingredients = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

}
