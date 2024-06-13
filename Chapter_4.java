/*
Унагаев Егор Б763-2
Вариант A
10. Создать приложение, удовлетворяющее требованиям, приведенным в задании. Наследование применять только в тех заданиях,
в которых это логически обосновано. Аргументировать принадлежность классу каждого создаваемого
метода и корректно переопределить для каждого класса методы equals(),hashCode(), toString().
Создать объект класса Щенок, используя классы Животное, Собака.
Методы: вывести на консоль имя, подать голос, прыгать, бегать, кусать.
*/
import java.util.Scanner;
import java.util.Objects;

class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("Животное издает звук");
    }

    public void jump() {
        System.out.println("Животное прыгает");
    }

    public void run() {
        System.out.println("Животное бежит");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Animal { Имя = '" + name + "' }";
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Собака лает");
    }

    public void bite() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите кого кусает собака: ");
        String whom = scanner.nextLine();
        System.out.println("Собака кусает " + whom);
    }

    @Override
    public String toString() {
        return "Dog { Имя = '" + name + "' }";
    }
}

class Puppy extends Dog {
    public Puppy(String name) {
        super(name);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Щенок играет с кем: ");
        String withWhom = scanner.nextLine();
        System.out.println("Щенок играет с " + withWhom);
    }

    @Override
    public String toString() {
        return "Puppy { Имя ='" + name + "' }";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя щенка: ");
        String name = scanner.nextLine();
        Puppy puppy = new Puppy(name);
        puppy.makeSound();
        puppy.jump();
        puppy.run();
        puppy.bite();
        puppy.play();
        System.out.println("Имя щенка: " + puppy.name);
    }
}
