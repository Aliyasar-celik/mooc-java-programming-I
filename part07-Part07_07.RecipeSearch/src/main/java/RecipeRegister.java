
import java.util.ArrayList;

public class RecipeRegister {

    ArrayList<Recipe> recipes;

    @Override
    public String toString() {
        return "RecipeRegister [recipes=" + recipes + "]";
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public RecipeRegister() {
        this.recipes = new ArrayList<Recipe>();

    }

    public void addRecipe(Recipe recipe) {

        recipes.add(recipe);
    }

    public ArrayList<Recipe> searchByName(String searchedWord) {

        ArrayList<Recipe> searchedRecipesByName = new ArrayList<Recipe>();

        for (Recipe recipe : this.recipes) {
            if (recipe.getName().contains(searchedWord)) {

                searchedRecipesByName.add(recipe);
            }

        }

        return searchedRecipesByName;

    }

    public ArrayList<Recipe> searchByCookingTime(int searchedCookingTime) {

        ArrayList<Recipe> searchedRecipesByCookingTime = new ArrayList<Recipe>();

        for (Recipe recipe : this.recipes) {
            if (recipe.getCookingTime() <= searchedCookingTime) {

                searchedRecipesByCookingTime.add(recipe);
            }

        }

        return searchedRecipesByCookingTime;

    }

    public ArrayList<Recipe> searchByIngredient(String searchedIngredient) {
        ArrayList<Recipe> searchedRecipesByIngredient = new ArrayList<Recipe>();

        for (Recipe recipe : this.recipes) {
            if (recipe.getIngredients().contains(searchedIngredient)) {
                searchedRecipesByIngredient.add(recipe);
            }
        }

        return searchedRecipesByIngredient;

    }

}
