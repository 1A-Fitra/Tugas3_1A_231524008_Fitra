public class RestaurantProcess {
    private static Restaurant menu = new Restaurant((byte) 10);

    public static Restaurant getMenu() {
        return menu;
    }

    public static void pengadaanStok() {
        menu.tambahMenu("Batagor", 5000, 20);
        menu.tambahMenu("Roti Bakar", 12000, 15);
        menu.tambahMenu("Indomie+Telor", 10000, 25);
        menu.tambahMenu("Kwetiau", 12000, 20);
        menu.tambahMenu("Nasi Goreng", 12000, 25);
        menu.tambahMenu("Air Mineral", 3000, 15);
        menu.tambahMenu("Teh Manis", 4000, 0);
        menu.tambahMenu("Jus Alpukat", 8000, 10);
        menu.tambahMenu("Teh Botol", 5000, 0);
        menu.tambahMenu("Kopi", 3000, 10);
    }
}