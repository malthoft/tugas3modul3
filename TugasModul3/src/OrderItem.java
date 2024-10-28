// File: OrderItem.java
public class OrderItem {
    private MenuItem menuItem;
    private int jumlah;
    private String catatanKhusus;

    public OrderItem(MenuItem menuItem, int jumlah, String catatanKhusus) {
        this.menuItem = menuItem;
        this.jumlah = jumlah;
        this.catatanKhusus = catatanKhusus;
    }

    public double getSubTotal() {
        return menuItem.getHarga() * jumlah;
    }

    // Getters
    public MenuItem getMenuItem() { return menuItem; }
    public int getJumlah() { return jumlah; }
    public String getCatatanKhusus() { return catatanKhusus; }
}
