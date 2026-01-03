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

        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println();
        System.out.print("Enter command: ");
        String command = scanner.nextLine();
        while(!command.equalsIgnoreCase("stop")){
           this.processCommand(command);
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

    private void processCommand(String command){


    }

}
