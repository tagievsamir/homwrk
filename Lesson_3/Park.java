/*3.Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах,
времени их работы и стоимости.*/
public class Park {
    String name;
    public Park(String name) {
        this.name = name;
    }
    public class Attraction{
        String attractionName;
        double workTime;
        double price;
        public Attraction(String attractionName, double workTime, double price) {
            this.attractionName = attractionName;
            this.workTime = workTime;
            this.price = price;
        }
    }
}
