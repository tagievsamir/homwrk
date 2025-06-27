package Shapes;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5, "Красный", "Чёрный"),
                new Rectangle(4, 6, "Жёлтый", "Синий"),
                new Triangle(3, 4, 5, "Зелёный", "Белый")
        };

        for (Shape shape : shapes) {
            System.out.println("Фигура: " + shape.getClass().getSimpleName());
            System.out.println("Площадь: " + shape.getArea());
            System.out.println("Периметр: " + shape.getPerimeter());
            System.out.println("Цвет заливки: " + shape.getFillColor());
            System.out.println("Цвет границы: " + shape.getBorderColor());
            System.out.println("------------------------");
        }
    }
}

