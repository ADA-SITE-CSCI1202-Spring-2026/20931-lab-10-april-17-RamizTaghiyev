import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Product {
    String name;
    double price; 
    boolean inStock;

    public Product(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Product: " + name;
    }

    public static void main(String[] args) {
        List<Product> li = new ArrayList<>(); 
        
        li.add(new Product("item1", 10.0, true)); 
        li.add(new Product("item2", 20.0, true));
        li.add(new Product("item3", 130.0, false)); 
        li.add(new Product("item4", 40.0, true));
        li.add(new Product("item5", 150.0, false));


        Predicate<Product> isAffordable = p -> p.price >= 50 || !p.inStock;
        
        li.removeIf(isAffordable);

        System.out.println("Filtered List:");
        li.forEach(p -> System.out.println(p));


        System.out.println(li);
    }
}
