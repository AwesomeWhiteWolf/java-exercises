/*
Унагаев Егор Б763-2
Вариант A
11. Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы. Определить дополнительно
методы в классе, создающем массив объектов. Задать критерий выбора данных
и вывести эти данные на консоль.
Bus: Фамилия и инициалы водителя, Номер автобуса, Номер маршрута,
Марка, Год начала эксплуатации, Пробег.
Создать массив объектов. Вывести:
a) список автобусов для заданного номера маршрута;
b) список автобусов, которые эксплуатируются больше заданного срока;
c) список автобусов, пробег у которых больше заданного расстояния.
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bus[] buses = {
                new Bus("Ivanov I.I.", "101", 1, "Mercedes", 2010, 150000),
                new Bus("Pavlov P.P.", "202", 2, "MAN", 2012, 120000),
                new Bus("Sokolov S.S.", "303", 3, "Volvo", 2014, 90000)
        };
        BusManagement busManagement = new BusManagement(buses);

        System.out.print("Enter route to search: ");
        int route = scanner.nextInt();
        System.out.println("Buses on route " + route + ":");
        busManagement.getBusesByRouteNumber(route);

        System.out.print("\nEnter years to search: ");
        int years = scanner.nextInt();
        System.out.println("Buses in operation for more than " + years + " years:");
        busManagement.getBusesByYearsInOperation(years);

        System.out.print("\nEnter mileage to search: ");
        int mileage = scanner.nextInt();
        System.out.println("Buses with mileage greater than " + mileage + ":");
        busManagement.getBusesByMileage(mileage);
    }
}
