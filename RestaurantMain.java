import java.util.Scanner;

public class RestaurantMain {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        char inputConfirmation;
        RestaurantProcess.pengadaanStok();
        PesanProduk pesanan = new PesanProduk();
        
        while (true) {
            pesanan.inputPesanan();
            pesanan.inputQuantity();
            pesanan.pesanProduk();

            inputConfirmation = pesanan.konfimasiPesanan();
            if (inputConfirmation == 'Y') continue;
            else if (inputConfirmation == 'T') break;
        }

        pesanan.showTotal();

        scanner.close();
    }
}
