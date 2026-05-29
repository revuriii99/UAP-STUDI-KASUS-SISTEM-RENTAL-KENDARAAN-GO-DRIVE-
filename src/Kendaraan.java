public class Kendaraan {
    private String kodeKendaraan;
    private String namaKendaraan;
    private double hargaSewaPerHari;
    private boolean isTersedia = true;

    public Kendaraan(String kodeKendaraan, String namaKendaraan, double hargaSewaPerHari) {
        this.kodeKendaraan = kodeKendaraan;
        this.namaKendaraan = namaKendaraan;
        this.hargaSewaPerHari = hargaSewaPerHari;
        this.isTersedia = isTersedia;
    }

    public String getKodeKendaraan(){
        return kodeKendaraan;
    }
    public void setKodeKendaraan(String kodeKendaraan){
        this.kodeKendaraan = kodeKendaraan;
    }
    public String getNamaKendaraan(String namaKendaraan){
        return namaKendaraan;
    }
    public void setNamaKendaraan(String namaKendaraan){
        this.namaKendaraan = namaKendaraan;
    }
    public double getHargaSewaPerHari(double hargaSewaPerHari){
        return hargaSewaPerHari;
    }
    public void setHargaSewaPerHari(double hargaSewaPerHari){
        this.hargaSewaPerHari = hargaSewaPerHari;
    }
    public boolean isTersedia(boolean isTersedia){
        return isTersedia;
    }
    public void setTersedia(boolean status){
        this.isTersedia = status;
    }

    public abstract void tampilinfo();
    public abstract double hitungBiayaDasar(int lamaSewa);
}
