public class Motor extends Kendaraan{
    private String jenisTransmisi;

    public Motor(String kodeKendaraan, String namaKendaraan, double hargaSewaPerHari, String jenisTransmisi) {
        super(kodeKendaraan, namaKendaraan, hargaSewaPerHari);
        this.jenisTransmisi = jenisTransmisi;
    }

    public String getJenisTransmisi(){
        return jenisTransmisi;
    }
    public void setJenisTransmisi(String jenisTransmisi){
        this.jenisTransmisi = jenisTransmisi;
    }

    @Override
    public void tampilInfo() {
        System.out.printf("[MOTOR] Kode: %s | Nama: %-20s | Transmisi: %-6s | Tarif: Rp%,.0f/hari | Status: %s%n",
                getKodeKendaraan(),
                getNamaKendaraan(),
                jenisTransmisi,
                getHargaSewaPerHari(),
                isTersedia() ? "Tersedia" : "Tidak Tersedia"
        );
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {
        double biaya = lamaSewa * getHargaSewaPerHari();
        if (jenisTransmisi.equalsIgnoreCase("Matik")) {
            biaya += 10000L * lamaSewa;
        }
        return biaya;
    }
}
