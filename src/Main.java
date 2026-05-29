import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static GoDriveRentalSystem system = new GoDriveRentalSystem();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            tampilMenu();
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> menuTambahKendaraan();
                case 2 -> system.tampilkanDaftarKendaraan();
                case 3 -> menuSewaKendaraan();
                case 4 -> menuKembalikanKendaraan();
                case 5 -> {
                    System.out.println("Terima kasih telah menggunakan GoDrive!");
                    running = false;
                }
                default -> System.out.println("[ERROR] Pilihan tidak valid.");
            }
        }
    }

    static void tampilMenu() {
        System.out.println("\n====== MENU GO DRIVE RENTAL SYSTEM ======");
        System.out.println("1. Tambah Kendaraan");
        System.out.println("2. Tampilkan Daftar Armada");
        System.out.println("3. Sewa Kendaraan");
        System.out.println("4. Kembalikan Kendaraan");
        System.out.println("5. Keluar");
    }

    static void menuTambahKendaraan() {
        System.out.print("Masukkan jenis kendaraan (mobil/motor): ");
        String jenis = scanner.nextLine().trim().toLowerCase();

        System.out.print("Masukkan kode kendaraan: ");
        String kode = scanner.nextLine().trim().toUpperCase();

        System.out.print("Masukkan nama kendaraan: ");
        String nama = scanner.nextLine().trim();

        System.out.print("Masukkan harga sewa per hari: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();

        if (jenis.equals("mobil")) {
            System.out.print("Masukkan kapasitas kursi: ");
            int kursi = scanner.nextInt();
            scanner.nextLine();
            system.tambahKendaraan(new Mobil(kode, nama, harga, kursi));

        } else if (jenis.equals("motor")) {
            System.out.print("Masukkan jenis transmisi (Matik/Manual): ");
            String transmisi = scanner.nextLine().trim();
            system.tambahKendaraan(new Motor(kode, nama, harga, transmisi));

        } else {
            System.out.println("[ERROR] Jenis kendaraan tidak valid.");
        }
    }

    static void menuSewaKendaraan() {
        System.out.print("Masukkan kode kendaraan yang ingin disewa: ");
        String kode = scanner.nextLine().trim().toUpperCase();

        System.out.print("Masukkan durasi sewa (dalam hari): ");
        int lama = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Apakah Anda Member VIP? (y/n): ");
        boolean isVIP = scanner.nextLine().trim().equalsIgnoreCase("y");

        try {
            system.sewaKendaraan(kode, lama, isVIP);
        } catch (KendaraanTidakTersediaException e) {
            System.out.println(e.getMessage());
        }
    }

    static void menuKembalikanKendaraan() {
        System.out.print("Masukkan kode kendaraan yang ingin dikembalikan: ");
        String kode = scanner.nextLine().trim().toUpperCase();
        system.kembalikanKendaraan(kode);
    }
}