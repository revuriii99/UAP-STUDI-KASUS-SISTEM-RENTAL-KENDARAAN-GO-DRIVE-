public class Motor extends Kendaraan{
    private String jenisTransmisi;

    public Motor(String kodeKendaraan, String namaKendaraan, double hargaSewaPerHari, String jenisTransmisi) {
        super(kodeKendaraan, namaKendaraan, hargaSewaPerHari);
        this.jenisTransmisi = jenisTransmisi;
    }

    public String getJenisTransmisi(String jenisTransmisi){
        return jenisTransmisi;
    }
    public void setJenisTransmisi(String jenisTransmisi){
        this.jenisTransmisi = jenisTransmisi;
    }

    public void tampilinfo(){

    }
}
