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
            System.out.println("The product was found: " + product.getProduct() + ", price: " + product.getPrice());
        } else {
            System.out.println("The product was not found");
        }
    }
}

class Product {
    private int price;
    private String product;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price<0||price>100){
            throw new IllegalArgumentException("Цена должна быть в диапазоне от 0 до 100");
        }
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

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
                if (product.getProduct().equalsIgnoreCase(name)) {
                    return product;
                }
            }
        }
        return null;
    }
}
