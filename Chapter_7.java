/*
Унагаев Егор Б763-2
Дано три разных целых числа. Реализовать лямбда-выражение,
которое находит наибольшее из этих трех чисел.
*/
import java.util.function.Function;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 3 числа: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        Function <Integer, Integer> max = x -> (x > b) ? (x > c ? x : c) : (b > c ? b : c);
        int result = max.apply(a);
        System.out.println("Наибольшее число: " + result);
    }
}
