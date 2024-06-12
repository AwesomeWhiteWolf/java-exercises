/*
Унагаев Егор Б763-2
Разработать многопоточное приложение. Использовать возможности, предоставляемыепакетомjava.util.concurrent.
Неиспользовать слово synchronized.Все сущности, желающие получить доступ к ресурсу, должны быть потоками.
Маленькая библиотека.Доступныдля чтения несколько книг. Одинаковыхкниг в библиотеке нет.
Некоторые выдаются на руки, некоторые только в читальный зал. Читатель может брать на руки и в читальный зал несколько книг
*/
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Library {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private final ConcurrentHashMap<Book, Integer> books = new ConcurrentHashMap<>();

    public void addBook(Book book) {
        books.put(book, 0);
        System.out.println("книга '" + book + "' была добавлена в библиотеку");
    }

    public void takeBook(Reader reader, Book book, boolean forReadingRoom) {
        executorService.submit(() -> {
            Integer count = books.get(book);
            if (count != null) {
                books.put(book, --count);
                reader.takeBook(book, forReadingRoom);
            }
        });
    }

    public void returnBook(Book book) {
        executorService.submit(() -> {
            Integer count = books.get(book);
            if (count < 1) {
                books.put(book, ++count);
            }
        });
    }

    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Мартин Иден");
        Book book2 = new Book("Трое в лодке, не считая собаки");
        Book book3 = new Book("Грокаем алгоритмы");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        Reader reader1 = new Reader("Reader1");
        Reader reader2 = new Reader("Reader2");

        library.takeBook(reader1, book1, true);
        library.takeBook(reader2, book2, false);

        library.returnBook(book1);
        library.returnBook(book2);

        executorService.shutdown();
    }

    private static class Book {
        private final String name;

        public Book(String name) {
            this.name = name;
            System.out.println("Была написана книга под названием: '" + name + "'");
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private static class Reader {
        private final String name;

        public Reader(String name) {
            this.name = name;
            System.out.println("Появился чтец под именем: " + name);
        }

        public void takeBook(Book book, boolean forReadingRoom) {
            if (forReadingRoom) {
                System.out.println(this.name + " взял '" + book + "' для чтения в библиотеке");
            } else {
                System.out.println(this.name + " взял '" + book + "' для чтения дома");
            }
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
