public class Main {
    public static void main(String[] args) {
        Dog sharik = new Dog("Sharik");
        //sharik.run(50);
        //sharik.swim(122);
        Cat barsik = new Cat("Barsic");
        //barsik.run(0);
        barsik.swim(0);
        System.out.println("Всего животных: " + Animal.getAnimalCounter());
        System.out.println("Всего котов: " + Cat.getCatCounter());
        System.out.println("Всего собак: " + Dog.getDogCounter());
    }
}
