public class Mobil extends Kendaraan{
    private int jumlahKursi;

    public Mobil(String kodeKendaraan,String namaKendaraan,double hargaSewaPerHari, int jumlahKursi) {
        super(kodeKendaraan, namaKendaraan, hargaSewaPerHari);
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi(int jumlahKursi){
        return jumlahKursi;
    }
    public void setJumlahKursi(int jumlahKursi){
        this.jumlahKursi = jumlahKursi;
    }

    public void tampilinfo(){

    }
}
