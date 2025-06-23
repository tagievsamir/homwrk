public class Main {
    public static void main(String[] args) {
        //2.Создать массив из 5 товаров
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Potatos", "22.06.2024", "Globus Inc.",
                                       "Belarus",100.50, true);
        productsArray[1] = new Product("Rice", "21.05.2024", "China rice",
                                       "China",55.55, false);
        productsArray[2] = new Product("Apples", "10.05.2024", "Orchard Ltd",
                                       "Poland", 120.35, false);
        productsArray[3] = new Product("Carrots", "15.06.2024", "Veggie Inc",
                                       "Russia", 99.99, true);
        productsArray[4] = new Product("Cucumbers", "18.06.2024", "Fresh Farm",
                                       "Ukraine", 95.20, true);
        for(Product p : productsArray) {
            p.productInfo();
        }
    }
}
