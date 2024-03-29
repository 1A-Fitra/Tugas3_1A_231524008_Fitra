public class Produk {
    private String nama_produk;
    private double harga;
    private int qty;

    public Produk(String nama_produk, double harga, int qty) {
        this.nama_produk = nama_produk;
        this.harga = harga;
        this.qty = qty;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void tampilProduk() {
        System.out.printf("%-15s[%2d] Rp. %.0f\n", nama_produk, qty, qty*harga);
    }
}
