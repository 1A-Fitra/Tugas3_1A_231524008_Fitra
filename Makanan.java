public class Makanan {
    private String nama_makanan;
    private double harga_makanan;
    private int stok;

    public Makanan(String nama_makanan, double harga_makanan, int stok) {
        this.nama_makanan = nama_makanan;
        this.harga_makanan = harga_makanan;
        this.stok = stok;
    }

    public int getStok() {
        return stok;
    }

    public String getNama_makanan() {
        return nama_makanan;
    }

    public double getHarga_makanan() {
        return harga_makanan;
    }

    public void setNama_makanan(String nama_makanan) {
        this.nama_makanan = nama_makanan;
    }

    public void setHarga_makanan(double harga_makanan) {
        this.harga_makanan = harga_makanan;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void tampilMakanan() {
        if (stok > 0)
            System.out.printf("%-15s[%2d] Rp. %.0f\n", nama_makanan, stok, harga_makanan);
        else
            System.out.printf("%-12s[HABIS] Rp. %.0f\n", nama_makanan, harga_makanan);
    }

}
