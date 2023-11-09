package refactoring.problema3_new;

public class Order {
    private int orderId;
    private String orderDate;
    private int itemId;
    private int quantity;

    public Order(int orderId, String orderDate, int itemId, int quantity) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public static Order fromString(String[] orderString) {
      return new Order(
        Integer.parseInt(orderString[0]),
        orderString[1],
        Integer.parseInt(orderString[2]),
        Integer.parseInt(orderString[3])
      );
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }
}
