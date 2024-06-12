public class ShoppingCenter implements Building {
    private String address;
    private double area;
    private int numberOfRooms;
    private int numberOfShops;

    public ShoppingCenter(String address, double area, int numberOfRooms, int numberOfShops) {
        this.address = address;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.numberOfShops = numberOfShops;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    @Override
    public double calculatePricePerSquareMeter() {
        return 2000;
    }

    @Override
    public void increaseArea(double increase) {
        area += increase;
    }

    @Override
    public void rent() {
        System.out.println("Торговый центр по адресу " + address + " сдан в аренду.");
    }

    @Override
    public void makeRepair(String room) {
        System.out.println("Ремонт в комнате " + room + " торгового центра " + address + " завершен.");
    }
}
