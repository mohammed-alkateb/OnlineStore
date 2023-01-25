import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private String description;
    private double price;
    private int stock;
    private String category;
    private static List<Product> products = new ArrayList<>();

    public Product(String name, String description, double price, int stock, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
        products.add(this);
    }

    public boolean addProduct(String name, String description, double price, int stock, String category) {
        for (Product product : products) {
            if (product.name.equals(name)) {
                return false;
            }
        }
        new Product(name, description, price, stock, category);
        return true;
    }

    public boolean updateProduct(String name, String description, double price, int stock, String category) {
        for (Product product : products) {
            if (product.name.equals(name)) {
                product.description = description;
                product.price = price;
                product.stock = stock;
                product.category = category;
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(String name) {
        for (Product product : products) {
            if (product.name.equals(name)) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProduct(String name) {
        for (Product product : products) {
            if (product.name.equals(name)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> searchByCategory(String category) {
        List<Product> results = new ArrayList<>();
        for (Product product : products) {
            if (product.category.equals(category)) {
                results.add(product);
            }
        }
        return results;
    }

    public boolean restock(String name, int amount) {
        for (Product product : products) {
            if (product.name.equals(name)) {
                product.stock += amount;
                return true;
            }
        }
        return false;
    }

    public boolean purchase(String name, int amount) {
        for (Product product : products) {
            if (product.name.equals(name) && product.stock >= amount) {
                product.stock -= amount;
                return true;
            }
        }
        return false;
    }
}