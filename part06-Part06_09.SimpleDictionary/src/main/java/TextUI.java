import java.util.Scanner;

public class TextUI {
    private Scanner scanner;
    private SimpleDictionary dictionary;

    public TextUI(Scanner scanner, SimpleDictionary dictionary) {

        this.scanner = scanner;
        this.dictionary = dictionary;
    }

    public void start() {

        System.out.print("Command: ");
        String commandString = this.scanner.nextLine();

        if (commandString.equals("end")) {

            System.out.println("Bye bye!");
            return;

        } else if (commandString.equals("add")) {

            System.out.print("Word: ");
            String word = this.scanner.nextLine();
            System.out.print("Translation: ");
            String translation = this.scanner.nextLine();
            this.dictionary.add(word, translation);
            start();

        } else if (commandString.equals("search")) {

            System.out.print("To be translated: ");
            String wordToTranslate = this.scanner.nextLine();
            String translation = this.dictionary.translate(wordToTranslate);

            if (translation != null && !translation.trim().isEmpty()) {

                System.out.println("Translation: " + translation);

            } else {

                System.out.println("Word " + wordToTranslate + " was not found");

            }

            start();
        } else {
            System.out.println("Unknown command");
            start();
        }
    }

}
