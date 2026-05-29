import java.util.ArrayList;

public class GoDriveRentalSystem {
    private ArrayList<Kendaraan> daftarKendaraan;

    public GoDriveRentalSystem() {
        daftarKendaraan = new ArrayList<>();
    }

    public void tambahKendaraan(Kendaraan k){
        daftarKendaraan.add(k);
        System.out.println("[INFO] Kendaraan berhasil ditambahkan: " + k.getNamaKendaraan() + " (" + k.getKodeKendaraan() + ")");
    }

    public void tampilkanDaftarKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("[INFO] Belum ada kendaraan yang terdaftar.");
            return;
        }
        System.out.println("\n=== DAFTAR ARMADA GODRIVE===");
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            System.out.print((i + 1) + ".");
            daftarKendaraan.get(i).tampilInfo();
        }
    }

    public void sewaKendaraan(String kodeKendaraan, int lamaSewa, boolean isVIP) {
        Kendaraan target = cariKendaraan(kodeKendaraan);

        if (target == null || !target.isTersedia()) {
            throw new KendaraanTidakTersediaException(
                    "Kendaraan dengan kode " + kodeKendaraan + " gagal disewa. " +
                            "Alasan: Kendaraan sedang disewa atau tidak ditemukan!"
            );
        }

        target.setTersedia(false);

        double biayaDasar = target.hitungBiayaDasar(lamaSewa);
        double totalBiaya = biayaDasar;
        double diskonVIP = 0;
        double diskonLama = 0;

        if (isVIP) {
            diskonVIP = biayaDasar * 0.10;
            totalBiaya -= diskonVIP;
        }

        if (lamaSewa > 7) {
            diskonLama = biayaDasar * 0.05;
            totalBiaya -= diskonLama;
        }

        System.out.println("\n=== TRANSAKSI SEWA GODRIVE ===");
        System.out.println("Kendaraan Berhasil Disewa!");
        System.out.printf("Unit        : %s (%s)%n", target.getNamaKendaraan(), target.getKodeKendaraan());
        System.out.printf("Lama Sewa   : %d hari%n", lamaSewa);
        System.out.printf("Biaya Dasar Harian : Rp%,.0f%n", target.getHargaSewaPerHari() * lamaSewa);

        if (target instanceof Mobil) {
            Mobil m = (Mobil) target;
            if (m.getJumlahKursi() > 5) {
                System.out.printf("Tambahan Kursi (>5): Rp 50,000%n");
            }
        } else if (target instanceof Motor) {
            Motor mt = (Motor) target;
            if (mt.getJenisTransmisi().equalsIgnoreCase("Matik")) {
                System.out.printf("Asuransi Matik     : Rp %,.0f%n", 10000.0 * lamaSewa);
            }
        }

        if (diskonVIP > 0)
            System.out.printf("Diskon Member VIP (10%%): -Rp %,.0f%n", diskonVIP);
        if (diskonLama > 0)
            System.out.printf("Diskon Sewa >7 Hari (5%%): -Rp %,.0f%n", diskonLama);

        System.out.println("----------------------------------------");
        System.out.printf("TOTAL BIAYA AKHIR: Rp %,.0f%n", totalBiaya);
    }

    public void kembalikanKendaraan(String kode) {
        Kendaraan target = cariKendaraan(kode);
        if (target == null) {
            System.out.println("[ERROR] Kendaraan dengan kode " + kode + " tidak ditemukan.");
            return;
        }
        target.setTersedia(true);
        System.out.println("[INFO] Kendaraan " + target.getNamaKendaraan()
                + " (" + kode + ") berhasil dikembalikan. Status: Tersedia.");
    }

    private Kendaraan cariKendaraan(String kode) {
        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }
}

