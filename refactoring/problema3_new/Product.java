package refactoring.problema3_new;

public class Product {
    private int itemId;
    private String item;
    private int quantity;

    public Product(int itemId, String item, int quantity) {
        this.itemId = itemId;
        this.item = item;
        this.quantity = quantity;
    }

    public static Product fromString(String[] productString) {
      return new Product(
        Integer.parseInt(productString[0]),
        productString[1],
        Integer.parseInt(productString[2])
      );
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
