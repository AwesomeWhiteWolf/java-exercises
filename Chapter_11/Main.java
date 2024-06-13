/*
Унагаев Егор Б763-2
Вариант A
1. Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
*/
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + inputFileName);
            e.printStackTrace();
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (int i = lines.size() - 1; i >= 0; i--) {
                String line = lines.get(i);
                writer.write(line);
                writer.newLine();
            }
            System.out.println(lines);

            System.out.println("Lines written to file: " + outputFileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + outputFileName);
            e.printStackTrace();
        }
    }
}
