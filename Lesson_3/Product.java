import java.util.Arrays;

/*Создать класс "Товар" с полями: название, дата производства, производитель, страна происхождения, цена,
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
        productInfo();
    }
    public void productInfo() {
        System.out.println("Product: " + name + ", Date: " + manufactureDate + ", Manufacturer: " + manufacturer +
                ", Country: " + country + ", Price: " + price + ", Reservation: " + reservationStatus);
    }


}
