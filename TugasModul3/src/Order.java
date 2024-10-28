import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private String noMeja;
    private ArrayList<OrderItem> items;
    private Date tanggalOrder;
    private boolean memberDiskon;

    public Order(String noMeja, boolean memberDiskon) {
        this.orderId = nextOrderId++;
        this.noMeja = noMeja;
        this.items = new ArrayList<>();
        this.tanggalOrder = new Date();
        this.memberDiskon = memberDiskon;
    }

    public void tambahItem(OrderItem item) {
        items.add(item);
    }

    public double hitungTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubTotal();
        }
        return total;
    }

    public double hitungDiskon() {
        double total = hitungTotal();
        if (memberDiskon) {
            return total * 0.10;
        }
        return 0;
    }

    public double hitungPajak() {

        return (hitungTotal() - hitungDiskon()) * 0.11;
    }

    public double hitungTotalAkhir() {
        return hitungTotal() - hitungDiskon() + hitungPajak();
    }

    public void cetakNota() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.println("\n=======================================");
        System.out.println("          KOREAN FOOD HOUSE            ");
        System.out.println("     Jl. Fufufafa No. 123     ");
        System.out.println("=======================================");
        System.out.println("No. Order: " + orderId);
        System.out.println("Tanggal  : " + sdf.format(tanggalOrder));
        System.out.println("No. Meja : " + noMeja);
        System.out.println("---------------------------------------");
        System.out.printf("%-4s %-20s %3s %10s%n", "No", "Menu", "Qty", "Subtotal");
        System.out.println("---------------------------------------");

        int no = 1;
        for (OrderItem item : items) {
            MenuItem menu = item.getMenuItem();
            System.out.printf("%-4d %-20s %3d %,10.0f%n",
                    no++,
                    menu.getNama(),
                    item.getJumlah(),
                    item.getSubTotal()
            );
            if (!item.getCatatanKhusus().isEmpty()) {
                System.out.println("     Catatan: " + item.getCatatanKhusus());
            }
        }

        System.out.println("---------------------------------------");
        System.out.printf("Subtotal        : %,14.0f%n", hitungTotal());
        if (memberDiskon) {
            System.out.printf("Diskon Member   : %,14.0f%n", hitungDiskon());
        }
        System.out.printf("PPN 11%%        : %,14.0f%n", hitungPajak());
        System.out.printf("Total           : %,14.0f%n", hitungTotalAkhir());
        System.out.println("=======================================");
        System.out.println("Terima kasih atas kunjungan Anda!");
        System.out.println("Selamat menikmati hidangan Korea kami");
        System.out.println("=======================================\n");
    }
}
