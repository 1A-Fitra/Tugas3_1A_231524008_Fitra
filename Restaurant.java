public class Restaurant {
    private Makanan[] makanans;
    private byte id = 0;

    public Restaurant() {
        makanans = new Makanan[10];
    }

    public Restaurant(int banyak_makanan) {
        makanans = new Makanan[banyak_makanan];
    }   

    public Makanan[] getMakanans() {
        return makanans;
    }

    public void setMakanans(Makanan[] makanans) {
        this.makanans = makanans;
    }

    public byte getId() {
        return this.id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public Makanan getMakanan(int idx) {
        return makanans[idx];
    }
    
    public void setMakanan(int idx, Makanan makanan) {
        this.makanans[idx] = makanan;
    }
    
    public void tambahMenu(String nama, double harga, int stok) {
        makanans[id] = new Makanan(nama, harga, stok);
        id++;
    }
    
    public void tampilMenu() {
        for (int i = 0; i < id; i++) {
            System.out.printf("%2d)", i+1);
            makanans[i].tampilMakanan();
        }
    }
    
    public boolean isOutOfStock(int idx) {
        if (makanans[idx].getStok() == 0)
        return true;
        else
        return false;
    }

    public void kurangiStok(int idx, int Pesanan) {
        makanans[idx].setStok(makanans[idx].getStok() - Pesanan);
    }

}