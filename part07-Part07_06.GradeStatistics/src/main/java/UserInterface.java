import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private GradeRegister gradeRegister;

    public UserInterface(Scanner scanner, GradeRegister gradeRegister) {

        this.scanner = scanner;
        this.gradeRegister = gradeRegister;
    }

    public void start() {

        System.out.println("Enter point totals, -1 stops:");
        int number;
        while (true) {
            number = Integer.valueOf(scanner.nextLine());
            if (number == -1) {

                break;

            } else if (number < 0 || number > 100) {

                continue;
            } else {
                this.gradeRegister.addPoint(number);
            }

        }

        System.out.println("Point average (all): " + this.gradeRegister.averageOfPoints());

        System.out.print("Point average (passing): ");
        if (this.gradeRegister.averageOfPassingPoints() == 0) {
            System.out.println("-");

        } else {
            System.out.println(this.gradeRegister.averageOfPassingPoints());

        }
        System.out.println("Pass percentage: " + this.gradeRegister.passPercentage());
        System.out.println("Grade distribution: ");
        for(int i = this.gradeRegister.getGradeList().length -1; 0 <= i  ; i-- ){

            System.out.print(i + ":");
            for (int j = 0; j < this.gradeRegister.getGradeList()[i]; j++){
                System.out.print("*");
            }
            System.out.println();

        }
    }

}
