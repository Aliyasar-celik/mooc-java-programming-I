import java.nio.file.Paths;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    RecipeRegister recipeRegister;

    public UserInterface(Scanner scanner, RecipeRegister recipeRegister) {

        this.recipeRegister = recipeRegister;
        this.scanner = scanner;

    }

    public void start() {
        System.out.println("File to read: ");
        String fileToRead = scanner.nextLine();
        this.readRecipeFile(fileToRead);
        
        System.out.println(
        );
        
        

        System.out.println(recipeRegister);
    }

    private void readRecipeFile(String fileToRead) {

        try (Scanner fileScanner = new Scanner(Paths.get(fileToRead))) {
            Recipe recipe = new Recipe();
            int lineCount = 0;
            // we read all the lines of the file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.isBlank()) {
                    this.recipeRegister.addRecipe(recipe);
                    recipe = new Recipe();
                    lineCount = 0;
                } else {
                    lineCount += 1;
                }

                if (lineCount == 1) {

                    recipe.setName(line);

                } else if (lineCount == 2) {

                    int cookingTime = Integer.valueOf(line);
                    recipe.setCookingTime(cookingTime);

                } else {

                    recipe.addIngredient(line);

                }
            }

        } catch (Exception readRecipeFilException) {

            System.out.println("Couldn' t read the recipe file.");
            System.out.println("Error: " + readRecipeFilException.getMessage());
        }

    }

}
