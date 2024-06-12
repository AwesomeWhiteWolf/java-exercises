/*
Унагаев Егор Б763-2
Дано три разных целых числа. Реализовать лямбда-выражение,
которое находит наибольшее из этих трех чисел.
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Character, Integer> charCount = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Egor\\IdeaProjects\\Chapter_1\\src\\input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }

        System.out.print("Введите количество символов для вывода: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("Символы, встречающиеся наиболее часто:");
        int count = 0;
        while (count < n) {
            int maxCount = 0;
            char maxChar = ' ';
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    maxChar = entry.getKey();
                }
            }

            if (maxCount == 0) {
                break; // все символы уже были выведены
            }

            System.out.println("'" + maxChar + "': " + maxCount);
            charCount.remove(maxChar);
            count++;
        }
    }
}