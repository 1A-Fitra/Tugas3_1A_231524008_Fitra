import java.util.ArrayList;

public class PesanProduk {
    private static ArrayList<Produk> pesanan = new ArrayList<>();
    private int inputIdx;
    private int inputQty;
    private double total = 0;

    public static ArrayList<Produk> getPesanan() {
        return pesanan;
    }

    public static void setPesanan(ArrayList<Produk> pesanan) {
        PesanProduk.pesanan = pesanan;
    }

    public int getInputIdx() {
        return inputIdx;
    }

    public void setInputIdx(int inputIdx) {
        this.inputIdx = inputIdx;
    }

    public int getInputQty() {
        return inputQty;
    }

    public void setInputQty(int inputQty) {
        this.inputQty = inputQty;
    }

    public static void tampilPesanan() {
        if (pesanan.isEmpty()) {
            System.out.println("========== TIDAK ADA PESANAN ==========");
        } else {
            for (Produk produk : pesanan) {
                produk.tampilProduk();
            }
        }
    }

    public static void header() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("~:~:~:~:~:~:~ MENU MAKANAN ~:~:~:~:~:~");
        RestaurantProcess.getMenu().tampilMenu();
        System.out.println("~:~:~:~:~:~:~ LIST PESANAN ~:~:~:~:~:~");
        tampilPesanan();
    }

    public void inputPesanan() {
        header();
        while (true) {
            System.out.print("Apa yang mau anda pesan? (1-10): ");
            inputIdx = RestaurantMain.scanner.nextInt();
            inputIdx--;
            if (inputIdx < 0 || inputIdx > 9) {
                header();
                System.out.println("ERROR: Invalid Input.");
                continue;
            } else if (RestaurantProcess.getMenu().isOutOfStock(inputIdx)) {
                header();
                System.out.println("ERROR: Out of Stock.");
                continue;
            } else {
                break;
            }
        }

    }

    public void inputQuantity() {
        header();
        while (true) {
            System.out.print("Berapa yang mau anda pesan:  ");
            inputQty = RestaurantMain.scanner.nextInt();

            if (inputQty < 1) {
                header();
                System.out.println("ERROF: Invalid Input.");
                continue;
            }
            else if (RestaurantProcess.getMenu().getMakanan(inputIdx).getStok() < inputQty) {
                header();
                System.out.println("ERROR: Stok Tidak Memadai");
                continue;
            } else {
                break;
            }
        }
    }

    public void pesanProduk() {

        Makanan makananDipesan = RestaurantProcess.getMenu().getMakanan(inputIdx);
        Produk dipesan = new Produk(makananDipesan.getNama_makanan(), makananDipesan.getHarga_makanan(), inputQty);
        RestaurantProcess.getMenu().kurangiStok(inputIdx, inputQty);
        total = total + inputQty*makananDipesan.getHarga_makanan();
        pesanan.add(dipesan);
    }

    public char konfimasiPesanan() {
        String inputConfirmation;

        header();

        while (true) {
            System.out.print("Pesan Lagi? [Y]/[T] " );

            System.out.flush();
            inputConfirmation = RestaurantMain.scanner.next();

            if (inputConfirmation.toUpperCase().charAt(0) == 'Y' || inputConfirmation.toUpperCase().charAt(0) == 'T')
                break;
            else
                header();
                System.out.println("ERROR: Invalid Input.");
                continue;
        }

        return inputConfirmation.toUpperCase().charAt(0);
    }

    public void showTotal() {
        header();
        System.out.println("TOTAL BAYAR: ");
        System.out.printf("Rp. %.0f", total);
    }
}
