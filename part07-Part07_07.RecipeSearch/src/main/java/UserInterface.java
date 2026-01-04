import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    RecipeRegister recipeRegister;

    public UserInterface(Scanner scanner, RecipeRegister recipeRegister) {

        this.recipeRegister = recipeRegister;
        this.scanner = scanner;

    }

    public void start() {
        System.out.print("File to read: ");
        String fileToRead = scanner.nextLine();
        this.readRecipeFile(fileToRead);
        System.out.println();

        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
        System.out.println();
        System.out.print("Enter command: ");
        String command = scanner.nextLine();
        System.out.println();

        while (!command.equalsIgnoreCase("stop")) {
            this.processCommand(command);
            System.out.println();
            System.out.print("Enter command: ");
            command = scanner.nextLine();
            System.out.println();

        }

    }

    private void readRecipeFile(String fileToRead) {

        try (Scanner fileScanner = new Scanner(Paths.get(fileToRead))) {
            Recipe recipe = null;
            int sectionLine = 0;

            // Format:
            // name
            // cooking time
            // ingredient(s)
            // (blank line separates recipes)
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isBlank()) {
                    if (recipe != null) {
                        this.recipeRegister.addRecipe(recipe);
                        recipe = null;
                    }
                    sectionLine = 0;
                    continue;

                }

                sectionLine++;
                if (sectionLine == 1) {
                    recipe = new Recipe();
                    recipe.setName(line);
                } else if (sectionLine == 2) {
                    int cookingTime = Integer.parseInt(line);
                    recipe.setCookingTime(cookingTime);
                } else {
                    recipe.addIngredient(line);
                }
            }

            if (recipe != null) {
                this.recipeRegister.addRecipe(recipe);
            }

        } catch (Exception readRecipeFilException) {

            System.out.println("Couldn' t read the recipe file.");
            System.out.println("Error: " + readRecipeFilException.getMessage());
        }

    }

    private void processCommand(String command) {
        if (command.equalsIgnoreCase("list")) {

            System.out.println("Recipes:");
            for (Recipe recipe : this.recipeRegister.getRecipes()) {
                System.out.println(recipe);
                // System.out.println(recipe.getName() + ", cooking time: " +
                // recipe.getCookingTime());
            }
        } else if (command.equalsIgnoreCase("find name")) {
            System.out.print("Searched word: ");
            String searchedWord = this.scanner.nextLine();

            ArrayList<Recipe> searchedRecipesByName = this.recipeRegister.searchByName(searchedWord);
            for (Recipe recipe : searchedRecipesByName) {
                System.out.println(recipe);
            }
        } else if (command.equalsIgnoreCase("find cooking time")) {
            System.out.print("Max cooking time: ");
            int searchedCookingTime = Integer.valueOf(this.scanner.nextLine());

            ArrayList<Recipe> searchedRecipeByCookingTime = this.recipeRegister
                    .searchByCookingTime(searchedCookingTime);

            for (Recipe recipe : searchedRecipeByCookingTime) {

                System.out.println(recipe);
            }

        } else if (command.equalsIgnoreCase("find ingredient")) {
            System.out.print("Ingredient: ");
            String searchedIngredient = this.scanner.nextLine();

            ArrayList<Recipe> searchedRecipesByIngredient = this.recipeRegister
                    .searchByIngredient(searchedIngredient);

            for (Recipe recipe : searchedRecipesByIngredient){

                System.out.println(recipe);
            }
            

        }

    }

}
