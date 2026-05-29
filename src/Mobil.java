public class Mobil extends Kendaraan{
    private int jumlahKursi;

    public Mobil(String kodeKendaraan,String namaKendaraan,double hargaSewaPerHari, int jumlahKursi) {
        super(kodeKendaraan, namaKendaraan, hargaSewaPerHari);
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi(){
        return jumlahKursi;
    }
    public void setJumlahKursi(int jumlahKursi){
        this.jumlahKursi = jumlahKursi;
    }

    @Override
    public void tampilInfo() {
        System.out.printf("[MOBIL] Kode: %s | Nama: %-20s | Kursi: %d | Tarif: Rp%,.0f/hari | Status: %s%n",
                getKodeKendaraan(),
                getNamaKendaraan(),
                jumlahKursi,
                getHargaSewaPerHari(),
                isTersedia() ? "Tersedia" : "Tidak Tersedia"
        );
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {
        double biaya = lamaSewa * getHargaSewaPerHari();
        if (jumlahKursi > 5) {
            biaya += 50000;
        }
        return biaya;
    }
}
