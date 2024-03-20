import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        products.add(new Beverage(15,"aqua",1.5));
        products.add(new Beverage(10,"aqua",1.0));
        products.add(new hotDrink(11,"tea",0.5,10));
        products.add(new hotDrink(11,"coffee",0.25,10));
        System.out.println("Menu:");
        System.out.println("aqua:"+" 1.5"+","+"1.0");
        System.out.println("tea"+" 0.5");
        System.out.println("coffe"+" 0.25");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Что вы хотите: ");
        String prod = scanner.nextLine();
        BeverageVendingMachine beverageMachine = new BeverageVendingMachine();
        VendingMachine1 productMachine = new VendingMachine1();
        hotDrinkVendingMachine hotDrinkMachine = new hotDrinkVendingMachine();

        beverageMachine.initProducts(products);
        productMachine.initProducts(products);
        hotDrinkMachine.initProducts(products);

        Product product = productMachine.getProduct(prod);
        if (product != null) {
            System.out.println("Product found: " + product.getProduct() + ", price: " + product.getPrice());
        } else {
            System.out.println("Product not found");
        }

        Beverage beverage = beverageMachine.getProduct("aqua", 1.0);
        if (beverage != null) {
            System.out.println("Product found: " + beverage.getProduct() + ", price: " + beverage.getPrice() + ", volume: " + beverage.getValume());
        } else {
            System.out.println("Product not found");
        }

        hotDrink hotDrink = hotDrinkMachine.getProduct("tea", 0.5, 10);
        if (hotDrink != null) {
            System.out.println("Product found: " + hotDrink.getProduct() + ", price: " + hotDrink.getPrice() + ", volume: " + hotDrink.getValume() + ", temperature: " + hotDrink.temperature);
        } else {
            System.out.println("Product not found");
        }
    }
}

class Product {
    protected int price;
    protected String product;

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
    @Override
    public String toString() {
        return "Beverage{" +
                "price=" + price +
                ", product='" + product + '\'' +
                "valume"+valume+"}  ";
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
//Домашняя задания
/*
 * @param temperature - Температура напитки
 */
class hotDrink extends Beverage {
    protected double temperature;

    public hotDrink(int price, String product, double valume,double temperature){
        super(price,product,valume);
        this.temperature=temperature;
    }
    @Override
    public String toString() {
        return "Hot Drink {" +
                "price=" + price +
                ", product='" + product +
                " valume= "+getValume()+" temperature= "+temperature;
    }
}
class hotDrinkVendingMachine extends VendingMachine1 implements VendingMachine{
    private List<Product> productList;
    @Override
    public void initProducts(List<Product> productList) {
        this.productList = productList;
    }
    public hotDrink getProduct(String name, double volume, double temperature) {
        if (productList != null) {
            for (Product product : productList) {
                if (product.getProduct().equalsIgnoreCase(name) && product instanceof hotDrink && ((hotDrink) product).getValume() == volume && ((hotDrink) product).temperature == temperature) {
                    return (hotDrink) product;
                }
            }
        }
        return null;
    }

}