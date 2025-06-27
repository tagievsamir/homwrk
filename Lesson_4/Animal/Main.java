package Animal;

public class Main {
    public static void main(String[] args) {
        Dog sharik = new Dog("Sharik");
        sharik.run(50);
        sharik.swim(122);
        Cat barsik = new Cat("Barsic",10);
        barsik.run(50);
        barsik.swim(10);
        Bowl bowl = new Bowl(100);
        Cat[] cats = {
                new Cat("Pushok",120),
                new Cat("Vaska", 30),
                new Cat("Murzik",50)
        };
        for(Cat cat : cats) {
            cat.eat(bowl);
            System.out.println(cat.getName() + ": " + (cat.isFull() ? "сыт" : "голоден"));
        }
        bowl.addFood(100);
        System.out.println("Всего животных: " + Animal.getAnimalCounter());
        System.out.println("Всего котов: " + Cat.getCatCounter());
        System.out.println("Всего собак: " + Dog.getDogCounter());
    }
}
