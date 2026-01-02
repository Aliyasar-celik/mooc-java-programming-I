
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

    public RecipeRegister(){
            this.recipes = new ArrayList<Recipe>();

    }

    public void addRecipe(Recipe recipe){

        recipes.add(recipe);
    }


}
