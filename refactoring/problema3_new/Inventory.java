package refactoring.problema3_new;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Inventory {

    @FunctionalInterface
    interface DataConstructor<T> {
        T create(String[] data);
    }

    private static final String CSV_FILE_PRODUCTS = "./refactoring/problema3/data/products.csv";
    private static final String CSV_FILE_SALES = "./refactoring/problema3/data/sales.csv";
    private static final String CSV_FILE_ORDERS = "./refactoring/problema3/data/orders.csv";
    private static final String CSV_SPLIT_BY = ",";

    public static void main(String[] args) {
        List<Product> products = loadProducts(CSV_FILE_PRODUCTS);
        List<Sale> sales = loadSales(CSV_FILE_SALES);
        List<Order> orders = loadOrders(CSV_FILE_ORDERS);

        updateInventory(products, orders, sales);
        printInventory(products);
    }

    private static <T> List<T> loadData(String filePath, DataConstructor<T> constructor) {
        try {
            return Files.lines(Paths.get(filePath))
                        .skip(1)
                        .map(line -> line.split(CSV_SPLIT_BY))
                        .map(constructor::create)
                        .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static List<Product> loadProducts(String filePath) {
        return loadData(filePath, Product::fromString);
    }

    private static List<Sale> loadSales(String filePath) {
        return loadData(filePath, Sale::fromString);
    }

    private static List<Order> loadOrders(String filePath) {
        return loadData(filePath, Order::fromString);
    }

    private static void updateInventory(List<Product> products, List<Order> orders, List<Sale> sales) {
        Map<Integer, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getItemId, product -> product));

        for (Order order : orders) {
            Product item = productMap.get(order.getItemId());
            if (item != null) {
                item.setQuantity(item.getQuantity() + order.getQuantity());
            } else {
                throw new RuntimeException("Product not found");
            }
        }

        for (Sale sale : sales) {
            Product item = productMap.get(sale.getItemId());
            if (item != null) {
                item.setQuantity(item.getQuantity() - sale.getQuantity());
            } else {
                throw new RuntimeException("Product not found");
            }
        }
    }

    private static void printInventory(List<Product> products) {
        products.forEach(product -> System.out.println(product.getItem() + " " + product.getQuantity()));
    }

}
