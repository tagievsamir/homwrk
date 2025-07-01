/*3.Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах,
времени их работы и стоимости.*/
public class Park {
    protected String name;

    public Park(String name) {
        this.name = name;
    }

    public class Attraction {
        private String attractionName;
        private double workTime;
        private double price;

        public Attraction(String attractionName, double workTime, double price) {
            this.attractionName = attractionName;
            this.workTime = workTime;
            this.price = price;
        }

        public void infoPark() {
            System.out.println("Name : " + this.attractionName);
            System.out.println("Time : " + this.workTime);
            System.out.println("Price : " + this.price);
            System.out.println("-----------------------");
        }
    }
}