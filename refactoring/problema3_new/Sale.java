package refactoring.problema3_new;

public class Sale {
    private int saleId;
    private String saleDate;
    private int itemId;
    private int quantity;

    public Sale(int saleId, String saleDate, int itemId, int quantity) {
        this.saleId = saleId;
        this.saleDate = saleDate;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public static Sale fromString(String[] saleString) {
      return new Sale(
        Integer.parseInt(saleString[0]),
        saleString[1],
        Integer.parseInt(saleString[2]),
        Integer.parseInt(saleString[3])
      );
    }

    public int getSaleId() {
        return saleId;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }
}
