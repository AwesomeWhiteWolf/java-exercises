public class Bus {
    private String driverName;
    private String busNumber;
    private int routeNumber;
    private String brand;
    private int year;
    private int mileage;

    public Bus(String driverName, String busNumber, int routeNumber, String brand, int year, int mileage) {
        this.driverName = driverName;
        this.busNumber = busNumber;
        this.routeNumber = routeNumber;
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
    }

    public String getDriverName() {
        return driverName;
    }
    public String getBusNumber() {
        return busNumber;
    }
    public int getRouteNumber() {
        return routeNumber;
    }
    public String getBrand() {
        return brand;
    }
    public int getYear() {
        return year;
    }
    public int getMileage() {
        return mileage;
    }
  
    public String toString() {
        return "Bus { " +
                "driverName='" + driverName + '\'' +
                ", busNumber='" + busNumber + '\'' +
                ", routeNumber=" + routeNumber +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                " }";
    }
}
