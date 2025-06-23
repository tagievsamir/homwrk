/*1.Создать класс "Товар" с полями: название, дата производства, производитель, страна происхождения, цена,
состояние бронирования покупателем.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.*/
public class Product {
    String name;
    String manufactureDate;
    String manufacturer;
    String country;
    double price;
    boolean reservationStatus;
    public Product(String name, String manufactureDate, String manufacturer, String country,
                   double price, boolean reservationStatus) {
        this.name = name;
        this.manufactureDate = manufactureDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.reservationStatus = reservationStatus;
    }
    public void productInfo() {
        System.out.println(" Product: " + name);
        System.out.println(" Date: " + manufactureDate);
        System.out.println(" Manufacturer: " + manufacturer);
        System.out.println(" Country: " + country);
        System.out.println(" Price: " + price);
        System.out.println(" Reservation: " + reservationStatus);
        System.out.println("-----------------------------------");
    }
}
