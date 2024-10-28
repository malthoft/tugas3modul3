import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static class ItemPesanan {
        String nama;
        double harga;
        int jumlah;

        ItemPesanan(String nama, double harga, int jumlah) {
            this.nama = nama;
            this.harga = harga;
            this.jumlah = jumlah;
        }

        double getTotal() {
            return harga * jumlah;
        }
    }

    private static final double PAJAK = 0.10; // Pajak 10%
    private static final double DISKON = 0.10; // Diskon 10%
    private static final double MINIMAL_DISKON = 50000; // Minimal 50rb untuk dapat diskon
    private ArrayList<ItemPesanan> daftarPesanan = new ArrayList<>();
    private String nomorMeja;

    // Menu sederhana
    private static final String[] menuNama = {
            "Nasi Goreng", "Ayam Goreng", "Es Teh", "Es Jeruk"
    };

    private static final double[] menuHarga = {
            25000, 30000, 5000, 7000
    };

    public Main(String nomorMeja) {
        this.nomorMeja = nomorMeja;
    }

    // Method untuk menghitung diskon
    private double hitungDiskon(double subtotal) {
        if (subtotal >= MINIMAL_DISKON) {
            return subtotal * DISKON;
        }
        return 0;
    }

    private void tampilkanMenu() {
        System.out.println("\n=== DAFTAR MENU ===");
        System.out.println("MAKANAN:");
        for (int i = 0; i < 2; i++) {
            System.out.printf("%d. %-20s Rp%.0f\n", (i + 1), menuNama[i], menuHarga[i]);
        }
        System.out.println("\nMINUMAN:");
        for (int i = 2; i < menuNama.length; i++) {
            System.out.printf("%d. %-20s Rp%.0f\n", (i + 1), menuNama[i], menuHarga[i]);
        }
        System.out.println("0. Selesai dan Cetak Nota");
        System.out.println("=====================");
        System.out.printf("* Diskon 10%% untuk pembelian minimal Rp%.0f\n", MINIMAL_DISKON);
    }

    private void tambahPesanan(int nomorMenu, int jumlah) {
        if (nomorMenu >= 1 && nomorMenu <= menuNama.length) {
            int index = nomorMenu - 1;
            daftarPesanan.add(new ItemPesanan(menuNama[index], menuHarga[index], jumlah));
        }
    }

    private void cetakNota() {
        double subtotal = 0;
        for (ItemPesanan item : daftarPesanan) {
            subtotal += item.getTotal();
        }

        double diskon = hitungDiskon(subtotal);
        double totalSetelahDiskon = subtotal - diskon;
        double pajak = totalSetelahDiskon * PAJAK;
        double totalAkhir = totalSetelahDiskon + pajak;

        System.out.println("\n=== NOTA PEMESANAN ===");
        System.out.println("Tanggal: " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()));
        System.out.println("Meja: " + nomorMeja);
        System.out.println("=====================");

        for (ItemPesanan item : daftarPesanan) {
            System.out.printf("%s x%d\n", item.nama, item.jumlah);
            System.out.printf("  @Rp%.0f = Rp%.0f\n", item.harga, item.getTotal());
        }

        System.out.println("=====================");
        System.out.printf("Subtotal: Rp%.0f\n", subtotal);
        if (diskon > 0) {
            System.out.printf("Diskon 10%%: -Rp%.0f\n", diskon);
        }
        System.out.printf("Pajak 10%%: Rp%.0f\n", pajak);
        System.out.printf("Total: Rp%.0f\n", totalAkhir);
        System.out.println("Terima kasih!");
        System.out.println("=====================\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEM PEMESANAN ===");
        System.out.print("Masukkan nomor meja: ");
        String nomorMeja = scanner.nextLine();

        Main resto = new Main(nomorMeja);

        while (true) {
            resto.tampilkanMenu();
            System.out.print("Pilih menu (0 untuk selesai): ");

            try {
                int nomorMenu = Integer.parseInt(scanner.nextLine());

                if (nomorMenu == 0) {
                    if (resto.daftarPesanan.isEmpty()) {
                        System.out.println("Belum ada pesanan yang ditambahkan!");
                        continue;
                    }
                    resto.cetakNota();
                    break;
                }

                if (nomorMenu < 1 || nomorMenu > menuNama.length) {
                    System.out.println("Nomor menu tidak valid!");
                    continue;
                }

                System.out.print("Jumlah: ");
                int jumlah = Integer.parseInt(scanner.nextLine());

                if (jumlah <= 0) {
                    System.out.println("Jumlah harus lebih dari 0!");
                    continue;
                }

                resto.tambahPesanan(nomorMenu, jumlah);
                System.out.println("Pesanan berhasil ditambahkan!");

            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Pastikan input berupa angka.");
            }
        }

        scanner.close();
    }
}