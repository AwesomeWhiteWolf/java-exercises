/*
Унагаев Егор Б763-2
В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия. При этом могут рассматриваться два варианта:
• каждая строка состоит из одного слова;
• каждая строка состоит из нескольких слов.
Имена входного и выходного файлов, а также абсолютный путь к ним могут
быть введены как параметры командной строки или храниться в файле.
В каждой строке найти слова, начинающиеся с гласной буквы
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "C:\\Users\\Egor\\IdeaProjects\\Chapter_1\\src\\input.txt";
        try {
            File inputFile = new File(inputFileName);
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (isVowel(word.toLowerCase().charAt(0))) {
                        System.out.println(word);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputFileName);
        }
    }

    public static boolean isVowel(char c) {
        return ("aeiouAEIOU".indexOf(c) != -1);
    }
}