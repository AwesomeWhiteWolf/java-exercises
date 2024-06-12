import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Locale;

class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\Egor\\IdeaProjects\\Chapter_1\\src\\input.txt"));
            scanner.useLocale(Locale.US); // Используем локаль с разделителем точкой
            double sum = 0;
            int count = 0;
            while (scanner.hasNext()) {
                try {
                    double number = scanner.nextDouble();
                    if (Double.isNaN(number) || Double.isInfinite(number)) {
                        throw new InvalidNumberException("Invalid number: " + number);
                    }
                    sum += number;
                    count++;
                } catch (InvalidNumberException | NumberFormatException e) {
                    System.err.println("Error reading number: " + e.getMessage());
                }
            }
            if (count == 0) {
                System.out.println("No valid numbers found in the file.");
            } else {
                double average = sum / count;
                System.out.println("Sum: " + sum);
                System.out.println("Average: " + average);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: input.txt");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}