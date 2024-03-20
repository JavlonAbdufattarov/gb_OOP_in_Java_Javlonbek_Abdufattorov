import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем список исходных продуктов
        List<Product> products = new ArrayList<>();
        products.add(new Product(10, "coffe"));
        products.add(new Product(15, "tea"));
        products.add(new Product(20, "ice cream"));

        // Инициализируем торговый автомат
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.initProducts(products);

        // Получаем продукты из торгового автомата по названию
        Product product = vendingMachine.getProduct("coffe");
        if (product != null) {
            System.out.println("The product was found: " + product.product + ", price: " + product.price);
        } else {
            System.out.println("The product was not found");
        }
    }
}

class Product {
    int price;
    String product;

    public Product(int price, String product) {
        this.price = price;
        this.product = product;
    }
}

class VendingMachine {
    private List<Product> productList;

    public void initProducts(List<Product> productList) {
        this.productList = productList;
    }

    public Product getProduct(String name) {
        if (productList != null) {
            for (Product product : productList) {
                if (product.product.equalsIgnoreCase(name)) {
                    return product;
                }
            }
        }
        return null;
    }
}
