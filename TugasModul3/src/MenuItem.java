
public class MenuItem {
    private String kode;
    private String nama;
    private double harga;
    private String kategori;
    private int levelPedas;

    public MenuItem(String kode, String nama, double harga, String kategori, int levelPedas) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
        this.levelPedas = levelPedas;
    }

    // Getters
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public String getKategori() { return kategori; }
    public int getLevelPedas() { return levelPedas; }
}
