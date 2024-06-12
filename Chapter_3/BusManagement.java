public class BusManagement {
    private Bus[] buses;

    public BusManagement(Bus[] buses) {
        this.buses = buses;
    }

    public void getBusesByRouteNumber(int routeNumber) {
        for (Bus bus : buses) {
            if (bus.getRouteNumber() == routeNumber) {
                System.out.println(bus);
            }
        }
    }

    public void getBusesByYearsInOperation(int years) {
        int currentYear = 2021;
        for (Bus bus : buses) {
            int yearsInOperation = currentYear - bus.getYear();
            if (yearsInOperation > years) {
                System.out.println(bus);
            }
        }
    }

    public void getBusesByMileage(int mileage) {
        for (Bus bus : buses) {
            if (bus.getMileage() > mileage) {
                System.out.println(bus);
            }
        }
    }
}
