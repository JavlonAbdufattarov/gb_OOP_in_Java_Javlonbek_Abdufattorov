import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем список исходных продуктов
        List<Product> products1 = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        products1.add(new Product(10, "coffe"));
        products1.add(new Product(15, "tea"));
        products1.add(new Product(20, "ice cream"));
        products.add(new Beverage(15,"aqua",1.5));
        products.add(new Beverage(10,"aqua",1.0));
        // Инициализируем торговый автомат
        String name = products1.toString();
        System.out.println(name);
        BeverageVendingMachine vendingMachine = new BeverageVendingMachine();
        vendingMachine.initProducts(products);
        VendingMachine1 vendMach = new VendingMachine1();
        vendMach.initProducts(products1);

        // Получаем продукты из торгового автомата по названию
        Product product = vendMach.getProduct("coffe");


        if (product != null) {
            System.out.println("The product was found: " + product.getProduct() + ", price: " + product.getPrice());
        } else {
            System.out.println("The product was not found");
        }
        Beverage prod  = vendingMachine.getProduct("aqua",1.0);

        if (prod != null) {
            System.out.println("The product was found: " + prod.getProduct() + ", price: " + prod.getPrice()+", valume: "+prod.getValume());
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
    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", product='" + product + '\'' +
                '}';
    }
}
class Beverage extends Product {
    private double valume;

    public double getValume() {
        return valume;
    }

    public void setValume(double valume) {
        this.valume = valume;
    }

    public Beverage(int price, String product, double valume) {
        super(price, product);
        this.valume =valume;
    }
}
class IceCream extends Product {
    public IceCream(int price, String product) {
        super(price, product);
    }
}
interface VendingMachine {
    void initProducts(List<Product> productList);
    Product getProduct(String name);
}

class VendingMachine1 implements VendingMachine {
    private List<Product> productList;
    @Override
    public void initProducts(List<Product> productList) {
        this.productList = productList;
    }
    @Override
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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VendingMachine1{products=").append(productList).append('}');
        return sb.toString();
    }
}
class BeverageVendingMachine extends VendingMachine1 implements VendingMachine {
    private List<Product> productList;

    @Override
    public void initProducts(List<Product> productList) {
        this.productList = productList;
    }

    public Beverage getProduct(String name, double volume) {
        if (productList != null) {
            for (Product product : productList) {
                if (product.getProduct().equalsIgnoreCase(name) && product instanceof Beverage && ((Beverage) product).getValume() == volume) {
                    return (Beverage) product;
                }
            }
        }
        return null;
    }
}

