/*

 */
public class Main {
    public static void main(String[] args) {
        BuildingBuilder houseBuilder = (address, area, numberOfRooms) -> new House(address, area, numberOfRooms);
        Building house = houseBuilder.build("Улица Ленина, 1", 100, 3);
        System.out.println("\nЦена за квадратный метр дома: " + house.calculatePricePerSquareMeter());
        System.out.println("Комнат в доме: " + house.getNumberOfRooms());

        BuildingBuilder officeBuilder = (address, area, numberOfRooms) -> new OfficeBuilding(address, area, numberOfRooms, 5);
        Building officeBuilding = officeBuilder.build("Проспект Мира, 5", 500, 10);
        System.out.println("\nЦена за квадратный метр офисного здания: " + officeBuilding.calculatePricePerSquareMeter());
        System.out.println("Комнат в офисе: " + officeBuilding.getNumberOfRooms());

        BuildingBuilder shoppingCenterBuilder = (address, area, numberOfRooms) -> new ShoppingCenter(address, area, numberOfRooms, 50);
        Building shoppingCenter = shoppingCenterBuilder.build("Тверская улица, 10", 1000, 20);
        System.out.println("\nЦена за квадратный метр торгового центра: " + shoppingCenter.calculatePricePerSquareMeter());
        System.out.println("Комнат в торговом центре: " + shoppingCenter.getNumberOfRooms());

    }
}
