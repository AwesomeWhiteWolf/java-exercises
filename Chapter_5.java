/*
Унагаев Егор Б763-2
Вариант А
10. Создать класс Mobile с внутренним классом, с помощью объектов которого
можно хранить информацию о моделях телефонов и их свойствах.
 */
class Mobile {
    private String brand;
    private String model;

    public Mobile(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }

    public static class MobileInfo {
        private int year;
        private int price;
        private int rom;

        public MobileInfo(int year, int price, int rom) {
            this.year = year;
            this.price = price;
            this.rom = rom;
        }
        public void displayMobileInfo() {
            System.out.println("Year of release: " + year);
            System.out.println("Price: " + price);
            System.out.println("ROM: " + rom + "\n");
        }
    }

    public static void main(String[] args) {
        Mobile samsung = new Mobile("Samsung", "Galaxy S21");
        MobileInfo samsungInfo = new MobileInfo(2021, 57999, 256);
        samsung.displayInfo();
        samsungInfo.displayMobileInfo();

        Mobile apple = new Mobile("Apple", "iPhone 15 Pro Max");
        MobileInfo appleInfo = new MobileInfo(2023, 147999, 256);
        apple.displayInfo();
        appleInfo.displayMobileInfo();
    }
}
