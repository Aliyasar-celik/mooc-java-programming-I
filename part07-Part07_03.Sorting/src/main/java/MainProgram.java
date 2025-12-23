import java.util.Arrays;

public class MainProgram {

    public static void main(String[] args) {
        // write your test code here
        // int[] array = { 3, 1, 5, 99, 3, 12 };
        int[] numbers = { 8, 3, 7, 9, 1, 2, 4 };
        MainProgram.sort(numbers);
    }

    public static int smallest(int[] array) {
        // write your code here
        int smallest = array[0];
        for (int number : array) {

            if (number < smallest)
                smallest = number;

        }
        return smallest;
    }

    public static int indexOfSmallest(int[] array) {

        int indexOfSmallest = 0;
        int smallest = array[0];
        for (int i = 0; i < array.length; i++) {

            if (array[i] < smallest) {
                smallest = array[i];
                indexOfSmallest = i;
            }
        }
        return indexOfSmallest;

    }

    public static int indexOfSmallestFrom(int[] table, int startIndex) {
        int indexOfSmallest = startIndex;
        int smallest = table[startIndex];
        for (int i = startIndex; i < table.length; i++) {

            if (table[i] < smallest) {
                smallest = table[i];
                indexOfSmallest = i;
            }
        }
        return indexOfSmallest;

    }

    public static void swap(int[] array, int index1, int index2) {
        int[] tempArray = Arrays.copyOf(array, array.length);
        array[index1] = tempArray[index2];
        array[index2] = tempArray[index1];

    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {

            System.out.println(Arrays.toString(array));

            MainProgram.swap(array, i, indexOfSmallestFrom(array, i));

        }
    }

}
