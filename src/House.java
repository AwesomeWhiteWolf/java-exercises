public class House implements Building {
    private String address;
    private double area;
    private int numberOfRooms;

    public House(String address, double area, int numberOfRooms) {
        this.address = address;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
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
        return 1000;
    }

    @Override
    public void increaseArea(double increase) {
        area += increase;
    }

    @Override
    public void rent() {
        System.out.println("Дом по адресу " + address + " сдан в аренду.");
    }

    @Override
    public void makeRepair(String room) {
        System.out.println("Ремонт в комнате " + room + " дома " + address + " завершен.");
    }
}
