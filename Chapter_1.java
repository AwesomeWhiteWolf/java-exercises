/*
Унагаев Егор Б763-2
Вариант B 
10. Ввести с консоли n целых чисел. На консоль вывести:
Числа-палиндромы,значения которых в прямом и обратном порядке совпадают.
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int num = 0;
        System.out.println("Введите " + n + " чисел:");
        for (int i = 0; i < n; i++) {
            num = scanner.nextInt();
            if (isPalindrome(num)) {
                System.out.println(num + " - палиндром");
            }
        }
    }

    public static boolean isPalindrome(int num) {
        int originalNum = num, reversedNum = 0, digit = 0;
        while (num != 0) {
            digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }
        return (originalNum == reversedNum);
    }
}
