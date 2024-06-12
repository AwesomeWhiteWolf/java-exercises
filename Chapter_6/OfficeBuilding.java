public class OfficeBuilding implements Building {
    private String address;
    private double area;
    private int numberOfRooms;
    private int numberOfFloors;

    public OfficeBuilding(String address, double area, int numberOfRooms, int numberOfFloors) {
        this.address = address;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.numberOfFloors = numberOfFloors;
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
        return 1500;
    }

    @Override
    public void increaseArea(double increase) {
        area += increase;
    }

    @Override
    public void rent() {
        System.out.println("Офисное здание по адресу " + address + " сдан в аренду.");
    }

    @Override
    public void makeRepair(String room) {
        System.out.println("Ремонт в комнате " + room + " офисного здания " + address + " завершен.");
    }
}
