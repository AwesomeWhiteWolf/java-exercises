public interface Building {
    String getAddress();
    double getArea();
    int getNumberOfRooms();
    double calculatePricePerSquareMeter();
    void increaseArea(double increase);
    void rent();
    void makeRepair(String room);

}
